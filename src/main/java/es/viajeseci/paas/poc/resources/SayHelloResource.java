package es.viajeseci.paas.poc.resources;

import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("/hi")
public class SayHelloResource {
  private static final String RESPONSE_TEXT = "Hello %s\n";
  private static final String DEFAULT_NAME  = "Unknown";
  
  private final Executor executor = Executors.newCachedThreadPool();
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public void sayHello(@Suspended final AsyncResponse asyncResponse,
                       @QueryParam("name") final Optional<String> name) {
    executor.execute(() -> {
      asyncResponse.resume(String.format(RESPONSE_TEXT, name.orElse(DEFAULT_NAME)));
    });    
  }
}
