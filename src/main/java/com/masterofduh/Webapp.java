package com.masterofduh;

import com.masterofduh.resources.CurrentTimeResource;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Webapp extends Application<Configuration> {
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration configuration, Environment environment)
            throws Exception {
        final CurrentTimeResource resource = new CurrentTimeResource();
        environment.jersey().register(resource);
    }

    @Override
    public String getName() {
        return "simple-webapp";
    }

    public static void main(String[] args) throws Exception {
        new Webapp().run(args);
    }
}
