# Using Oracle GraalVM for JDK 17
FROM container-registry.oracle.com/graalvm/native-image:17-ol8 AS builder

# Set the working directory to /home/app
WORKDIR /build

# Copy the source code into the image for building
COPY . /build
RUN chmod 777 ./mvnw

# Build
RUN ./mvnw --no-transfer-progress native:compile -Pnative

# The deployment Image
FROM container-registry.oracle.com/os/oraclelinux:8-slim

EXPOSE 8080

# Copy the native executable into the containers
COPY --from=builder /build/target/spring-boot3-native-demo app
ENTRYPOINT ["/app"]
