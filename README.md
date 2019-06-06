GraalVM native image
====================

Graal native image demo with RSocket, Netty.

# Graal reflection configuration

please use native-image.properties and reflection-config.json, the directory is resource/META-INFO/native-image/xxx.your_groupId/your_artifactId/native-image.properties

* Netty: src/main/resources/META-INF/native-image/io.netty/codec-http/native-image.properties

# Build

<!--[demo]:second-->
```bash
mvn -DskipTests clean package native-image:native-image
```

# References

* Ahead-of-time Compilation: https://www.graalvm.org/docs/reference-manual/aot-compilation/
* native-image-maven-plugin: https://github.com/oracle/graal/blob/master/substratevm/src/native-image-maven-plugin/src/main/java/com/oracle/substratevm/NativeImageMojo.java
* native image reflection configuration: https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md
* GraalVM release notes: https://www.graalvm.org/docs/release-notes/
* RSocket Java: https://github.com/rsocket/rsocket-java
* Spring Boot with Graal: https://github.com/dsyer/spring-boot-micro-apps
* Simplifying native-image generation with Maven plugin and embeddable configuration: https://medium.com/graalvm/simplifying-native-image-generation-with-maven-plugin-and-embeddable-configuration-d5b283b92f57
* Introducing the Tracing Agent: Simplifying GraalVM Native Image Configuration: https://medium.com/graalvm/introducing-the-tracing-agent-simplifying-graalvm-native-image-configuration-c3b56c486271
* Dynamic proxies on Substrate VM: https://github.com/oracle/graal/blob/master/substratevm/DYNAMIC_PROXY.md

