package org.mvnsearch;

import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.server.TcpServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

/**
 * RSocket base server
 *
 * @author linux_china
 */
public abstract class RSocketBaseServer {
    private Logger log = LoggerFactory.getLogger(RSocketAppServer.class);

    public void start() {
        log.info("Begin to start the rsocket server");
        RSocketFactory.receive()
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(new SimpleResponderHandler()))
                .transport(TcpServerTransport.create("0.0.0.0", port()))
                .start()
                .subscribe();
    }

    public abstract int port();

    public abstract String serverId();

}
