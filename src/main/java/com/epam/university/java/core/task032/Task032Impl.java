package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class Task032Impl implements Task032 {
    /**
     * Create proxy wrapper.
     *
     * @return proxy instance
     */
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl(new SomeActionExecutor() {
            @Override
            public void doAction() {

            }

            @Override
            public void doAnotherAction() {

            }
        });
    }

    /**
     * Create action executor with given proxy instance.
     *
     * @param proxy proxy instance
     * @return action executor instance
     */
    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        SomeActionExecutor executor = (SomeActionExecutor)
                ((CountingProxyImpl) proxy).getInstance(new SomeActionExecutor() {
                    @Override
                    public void doAction() {

                    }

                    @Override
                    public void doAnotherAction() {

                    }
                });
        return executor;
    }
}
