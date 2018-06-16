package ru.st.qa.jUnitTests.drafts.rules;

import org.junit.rules.ExternalResource;

public  class ReusableRule extends ExternalResource {
        @Override
        protected void before() throws Throwable {
            System.out.println("-------------------------------");
            System.out.println(" test1 setUp");
        }

        @Override
        protected void after() {
            System.out.println(" test1 tear down");
        }
    }