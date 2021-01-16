export GRAAL_HOME := "~/.jenv/candidates/java/graalvm-20.3.0-java11"

# maven build
build:
   mvn -DskipTests clean package

# native build
native_build:
   mvn -DskipTests clean package native-image:native-image

# run with agent
run-with-agent: build
   mkdir -p target/native-image
   {{GRAAL_HOME}}/bin/java -agentlib:native-image-agent=config-output-dir=target/native-image -jar target/native-image-demo-1.0.0-SNAPSHOT-jar-with-dependencies.jar
