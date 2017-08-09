package de.safisto.microservice.demo.meecrowave.jaxrs;

import javax.enterprise.context.Dependent;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Dependent
@ApplicationPath("api")
public class HelloApplication extends Application {
}
