export GRAAL_HOME := "$HOME/.jenv/candidates/java/graalvm-21.3-java17"

# maven build
build:
   mvn -DskipTests clean package

# truffle run with espresso
truffle-run:
  java -truffle -jar target/native-image-demo-1.0.0-SNAPSHOT-jar-with-dependencies.jar

# native build
native-build:
   mvn -DskipTests clean package native:build

# run with agent
run-with-agent: build
   mkdir -p target/native-image
   {{GRAAL_HOME}}/bin/java -agentlib:native-image-agent=config-output-dir=target/native-image -jar target/native-image-demo-1.0.0-SNAPSHOT-jar-with-dependencies.jar
