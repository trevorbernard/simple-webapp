package com.masterofduh;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.masterofduh.resources.CurrentTimeResource;

//imports by travis

import io.dropwizard.Application;
import io.dropwizard.*;
import io.dropwizard.setup.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

public class Webapp extends Application<Configuration> {

	@JsonProperty
	private @NotEmpty
	String firstName = "travis";
	@JsonProperty
	private @NotEmpty
	String lastName = "martin";

	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {
	}

	@Override
	public void run(Configuration configuration, Environment environment)
			throws Exception {
		final CurrentTimeResource resource = new CurrentTimeResource();
		final trolling_trev resource_2 = new trolling_trev();
		environment.jersey().register(resource_2);
	}

	@Override
	public String getName() {
		return "simple-webapp";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Path("/Hello-world")
	@Produces(MediaType.APPLICATION_JSON)
	public static class trolling_trev {
		public final AtomicLong counter = new AtomicLong();

		@GET
		public Map<String, Object> sayHello(@QueryParam("name") String name) {

			Map<String, Object> res = new HashMap<>();
			res.put("content", "What Trev, go eat a hot pepper!");
			return res;
		}

	}

	public static void main(String[] args) throws Exception {
		new Webapp().run(args);

	}
}
