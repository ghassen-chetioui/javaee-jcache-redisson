package io.github.cgh;

import javax.cache.annotation.CacheResult;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

    @GET
    @CacheResult(cacheName = "orders")
    public List<String> get() {
        System.out.println("Get orders");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Logger.getAnonymousLogger().severe(e.getLocalizedMessage());
        }
        return Arrays.asList("coffee", "thee", "juice");
    }

}
