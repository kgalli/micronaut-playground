FROM oracle/graalvm-ce:19.3.0-java8 as graalvm
#FROM oracle/graalvm-ce:19.3.0-java11 as graalvm # For JDK 11
COPY . /home/app/bookshop
WORKDIR /home/app/bookshop
RUN gu install native-image
RUN native-image --no-server --static -cp build/libs/bookshop-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/bookshop/bookshop /app/bookshop
ENTRYPOINT ["/app/bookshop", "-Djava.library.path=/app"]
