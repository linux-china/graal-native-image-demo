package org.mvnsearch;

import org.graalvm.polyglot.Context;
import org.junit.jupiter.api.Test;

/**
 * GraalVM polyglot test
 *
 * @author linux_china
 */
public class GraalPolyglotTest {

    @Test
    public void testJs() {
        System.out.println("Hello Java!");
        try (Context context = Context.create()) {
            context.eval("js", "print('Hello JavaScript!');");
        }
    }
}
