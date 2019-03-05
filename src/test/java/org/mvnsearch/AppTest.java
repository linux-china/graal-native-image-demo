package org.mvnsearch;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import reactor.core.publisher.Mono;

/**
 * app test
 *
 * @author linux_china
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {
    private RSocket requester;

    @BeforeAll
    public void setUp() throws Exception {
        requester = RSocketFactory.connect().transport(TcpClientTransport.create("127.0.0.1", 11111)).start().block();
    }

    @AfterAll
    public void tearDown() {
        requester.dispose();
    }

    /**
     * request/response test
     */
    @Test
    public void testRequestResponse() throws Exception {
        Mono<Payload> result = requester.requestResponse(DefaultPayload.create("peace"));
        result.subscribe(payload -> {
            System.out.println(payload.getDataUtf8());
        });
        Thread.sleep(1000);
    }
}
