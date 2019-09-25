package io.github.cgh.orders.boundary;

import io.github.cgh.orders.entity.Order;

import javax.cache.annotation.CacheResult;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrdersResource {

    @Inject
    private Orders orders;

    @Context
    private UriInfo uriInfo;

    @GET
    public Response getOrders() {
        return Response.ok(orders.all()).build();
    }

    @GET
    @Path("{id}")
    public Response getOrder(@PathParam("id") String orderId) {
        Order order = orders.byId(orderId);
        return order != null ? Response.ok(order).build() : Response.status(NOT_FOUND).build();
    }

    @POST
    public Response createOrder(Order order) {
        orders.create(order);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(order.getId()).build()).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") String orderId) {
        orders.delete(orderId);
    }

}
