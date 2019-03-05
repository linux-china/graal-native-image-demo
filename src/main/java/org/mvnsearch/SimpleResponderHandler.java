package org.mvnsearch;

import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

/**
 * simple responder rsocket handler
 *
 * @author linux_china
 */
public class SimpleResponderHandler extends AbstractRSocket {
    @Override
    public Mono<Payload> requestResponse(Payload payload) {
        System.out.println("payload:" + payload.getDataUtf8());
        return Mono.just(DefaultPayload.create("received" + ":" + payload.getDataUtf8()));
    }
}
