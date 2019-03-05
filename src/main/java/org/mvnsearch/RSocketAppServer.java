package org.mvnsearch;

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

}
