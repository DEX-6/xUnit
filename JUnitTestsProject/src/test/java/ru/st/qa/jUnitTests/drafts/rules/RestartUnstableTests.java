package ru.st.qa.jUnitTests.drafts.rules;

import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import ru.st.qa.jUnitTests.drafts.categories.Unstable;

public class RestartUnstableTests extends TestWatcher implements TestRule {
    @Override
    protected void starting(Description description) {
        if (description.getAnnotation(Unstable.class) != null) {
            try {
                Unstable.class.getField("countOfRetry");
            } catch (NoSuchFieldException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Statement apply(Statement base, Description desc) {
        return new RerunStatement(base, desc);
    }

    public class RerunStatement extends Statement {
        private final Statement base;
        private Description desc;
        int attampt = 0;

        public RerunStatement(Statement base, Description desc) {
            this.base = base;
            this.desc = desc;
        }

        @Override
        public void evaluate() throws Throwable {
            Unstable unstable = desc.getAnnotation(Unstable.class);
            boolean isSuccess = false;
            if (unstable != null) {
                while (!isSuccess && attampt < unstable.countOfRetry()) {
                    try {
                        base.evaluate();
                        isSuccess = true;
                    } catch (Throwable t) {
                        System.out.println("Failed on " + (attampt + 1) + " attampt" + desc);
                        isSuccess = false;
                        attampt++;
                        evaluate();
                    }
                    attampt++;
                }
            }
        }
    }

}
