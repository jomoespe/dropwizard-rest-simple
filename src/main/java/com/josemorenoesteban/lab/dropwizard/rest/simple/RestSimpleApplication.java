package com.josemorenoesteban.lab.dropwizard.rest.simple;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestSimpleApplication extends Application<Configuration> {

  public static void main(String... args) throws Exception {
    new RestSimpleApplication().run(args);
  }

  @Override
  public void initialize(final Bootstrap<Configuration> bootstrap) {
    bootstrap.addBundle(new Java8Bundle());
  }

  @Override
  public void run(final Configuration config, final Environment environment) throws Exception {
    environment.jersey().register(new SayHelloResource());
  }
}
