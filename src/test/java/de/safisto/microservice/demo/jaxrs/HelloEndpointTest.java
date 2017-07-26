package de.safisto.microservice.demo.jaxrs;

import org.apache.meecrowave.Meecrowave;
import org.apache.meecrowave.junit.MonoMeecrowave;
import org.apache.meecrowave.testing.ConfigurationInject;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.junit.Assert.assertEquals;

@RunWith(MonoMeecrowave.Runner.class)
public class HelloEndpointTest {
    @ConfigurationInject
    private Meecrowave.Builder configuration;

    @Test
    public void hello() {
        final Client client = ClientBuilder.newClient();
        try {
            assertEquals("me", client.target("http://localhost:" + configuration.getHttpPort())
                    .path("api/hello")
                    .queryParam("name", "me")
                    .request(APPLICATION_JSON_TYPE)
                    .get(HelloEndpoint.Hello.class)
                    .getName());
        } finally {
            client.close();
        }
    }
}
