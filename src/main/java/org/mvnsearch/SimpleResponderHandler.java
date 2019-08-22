package org.mvnsearch;

import io.rsocket.AbstractRSocket;
import io.rsocket.Payload;
import io.rsocket.util.DefaultPayload;
import org.mvnsearch.proxy.HelloService;
import org.mvnsearch.proxy.HelloServiceProxyHandler;
import reactor.core.publisher.Mono;

import java.lang.reflect.Proxy;

/**
 * simple responder rsocket handler
 *
 * @author linux_china
 */
public class SimpleResponderHandler extends AbstractRSocket {
    HelloService helloService = (HelloService) Proxy.newProxyInstance(RSocketAppServer.class.getClassLoader(), new Class<?>[]{HelloService.class}, new HelloServiceProxyHandler());

    @Override
    public Mono<Payload> requestResponse(Payload payload) {
        System.out.println("payload:" + payload.getDataUtf8());
        return Mono.just(DefaultPayload.create(helloService.hello(payload.getDataUtf8())));
    }
}
