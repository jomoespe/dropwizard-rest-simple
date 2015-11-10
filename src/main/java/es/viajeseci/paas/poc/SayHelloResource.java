package es.viajeseci.paas.poc;

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
  private final Executor executor = Executors.newCachedThreadPool();  // Dani, esto debería estudiarse bien ;)
   
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public void sayHello(@Suspended final AsyncResponse asyncResponse,
                       @QueryParam("name") final Optional<String> name) {
    executor.execute(() -> {
      asyncResponse.resume("hello " + name.orElse("<unknown>"));
    });    
  }

}
