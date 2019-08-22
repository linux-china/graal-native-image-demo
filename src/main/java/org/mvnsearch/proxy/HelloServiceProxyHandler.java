package org.mvnsearch.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Hello Service proxy handler
 *
 * @author linux_china
 */
public class HelloServiceProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("hello")) {
            return "Hello " + args[0];
        } else {
            return "Hi";
        }
    }
}
