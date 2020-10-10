package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

public class Task032Impl implements Task032 {

    /**
     * Create proxy wrapper.
     *
     * @return proxy instance
     */
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    /**
     * Create action executor with given proxy instance.
     *
     * @param proxy proxy instance
     * @return action executor instance
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return new SomeActionExecutor() {
            @Override
            public void doAction() {

            }

            @Override
            public void doAnotherAction() {

            }
        };
    }
}
