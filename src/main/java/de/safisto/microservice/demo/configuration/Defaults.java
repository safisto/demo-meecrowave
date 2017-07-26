package de.safisto.microservice.demo.configuration;

import org.apache.meecrowave.runner.Cli;
import org.apache.meecrowave.runner.cli.CliOption;

public class Defaults implements Cli.Options {
    @CliOption(name = "app-default-name", description = "The name used to say hello if not set")
    private String name = "default value";

    public String getName() {
        return name;
    }
}
