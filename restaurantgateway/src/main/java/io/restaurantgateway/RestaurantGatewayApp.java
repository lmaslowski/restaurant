package io.restaurantgateway;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestaurantGatewayApp {

    public static void main(String[] args) {
        MuServer server = MuServerBuilder.httpServer()
                .withHttpPort(8081)
                .addHandler(Method.GET, "/api/restaurant/booking", (request, response, map) -> {
                    response.write(HttpClient.newBuilder()
                            .build()
                            .send(HttpRequest.newBuilder()
                                            .uri(new URI("http://127.0.0.1:9991/restaurant/bookingview"))
                                            .headers("Content-Type", "application/json;charset=UTF-8")
                                            .GET()
                                            .build(),
                                    HttpResponse.BodyHandlers.ofString())
                            .body());
                })
                .addHandler(Method.POST, "/api/restaurant/booking", (request, response, pathParams) -> {
                    response.write(HttpClient.newBuilder()
                            .build()
                            .send(HttpRequest.newBuilder()
                                            .uri(new URI("http://127.0.0.1:9991/restaurant/booking"))
                                            .headers("Content-Type", "application/json;charset=UTF-8")
                                            .POST(HttpRequest.BodyPublishers.ofString(request.readBodyAsString()))
                                            .build(),
                                    HttpResponse.BodyHandlers.ofString())
                            .body());
                })
                .start();

        System.out.println("Started server at " + server.uri());
    }
}
