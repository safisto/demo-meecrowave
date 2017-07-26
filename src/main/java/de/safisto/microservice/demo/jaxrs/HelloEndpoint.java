package de.safisto.microservice.demo.jaxrs;

import de.safisto.microservice.demo.configuration.Defaults;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import static java.util.Optional.ofNullable;

@Path("hello")
@ApplicationScoped
public class HelloEndpoint {
    @Inject
    private Defaults defaults;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayHi(@QueryParam("name") final String name) {
        return new Hello(ofNullable(name).orElse(defaults.getName()));
    }

    public static class Hello {
        private String name;

        public Hello() {
            // no-op
        }

        private Hello(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }
}
