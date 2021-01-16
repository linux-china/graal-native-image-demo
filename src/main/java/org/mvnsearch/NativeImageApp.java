package org.mvnsearch;

import org.mvnsearch.proxy.HelloService;
import org.mvnsearch.proxy.HelloServiceProxyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * Native Image App
 *
 * @author linux_china
 */
public class NativeImageApp {
    private static final Logger log = LoggerFactory.getLogger(NativeImageApp.class);

    public static void main(String[] args) throws Exception {
        HelloService helloService = (HelloService) Proxy.newProxyInstance(NativeImageApp.class.getClassLoader(), new Class<?>[]{HelloService.class}, new HelloServiceProxyHandler());
        String welcome = helloService.hello("Jackie");
        System.out.println(welcome);
        log.info("goood");
    }

}
