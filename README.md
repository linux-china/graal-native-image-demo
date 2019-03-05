GraalVM native image
====================

Graal native image demo with RSocket, Netty.

# Graal reflection configuration

* graal.json:  for Netty
* graal_springboot: for Spring Boot

# Build

<!--[demo]:second-->
```bash
mvn -DskipTests clean package native-image:native-image
```

# References

* native-image-maven-plugin: https://github.com/oracle/graal/blob/master/substratevm/src/native-image-maven-plugin/src/main/java/com/oracle/substratevm/NativeImageMojo.java
* native image reflection configuration: https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md
* GraalVM release notes: https://www.graalvm.org/docs/release-notes/
* RSocket Java: https://github.com/rsocket/rsocket-java
* Spring Boot with Graal: https://github.com/dsyer/spring-boot-micro-apps
