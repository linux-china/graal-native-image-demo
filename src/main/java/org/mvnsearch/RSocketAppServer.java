package org.mvnsearch;

import org.mvnsearch.proxy.DemoService;
import org.mvnsearch.proxy.MyProxyHandler;

import java.lang.reflect.Proxy;
import java.util.concurrent.CountDownLatch;

/**
 * rsocket app server
 *
 * @author linux_china
 */
public class RSocketAppServer extends RSocketBaseServer {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        (new RSocketAppServer()).start();
        latch.await();
    }

    @Override
    public int port() {
        return 11111;
    }

    @Override
    public String serverId() {
        return "server1";
    }

    public static void proxyTest() {
        DemoService demoService = (DemoService) Proxy.newProxyInstance(RSocketAppServer.class.getClassLoader(), new Class<?>[]{DemoService.class}, new MyProxyHandler());
        demoService.hello("RSocket");
    }
}
