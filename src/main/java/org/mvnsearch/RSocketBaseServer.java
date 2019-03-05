package org.mvnsearch;

import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * RSocket base server
 *
 * @author linux_china
 */
public abstract class RSocketBaseServer {
    private Logger log = LoggerFactory.getLogger(App.class);

    public void start() {
        log.info("Begin to start the rsocket server");
        RSocketFactory.receive()
                .acceptor(
                        (setupPayload, reactiveSocket) ->
                                Mono.just(
                                        new AbstractRSocket() {

                                            @Override
                                            public Mono<Payload> requestResponse(Payload p) {
                                                System.out.println("payload:" + p.getDataUtf8());
                                                return Mono.just(DefaultPayload.create(serverId() + ":" + new Date()));
                                            }
                                        }))
                .transport(TcpServerTransport.create("0.0.0.0", port()))
                .start()
                .subscribe();
    }

    public abstract int port();

    public abstract String serverId();

}
