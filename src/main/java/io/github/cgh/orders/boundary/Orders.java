package io.github.cgh.orders.boundary;

import io.github.cgh.orders.entity.Order;

import javax.cache.annotation.*;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Orders {

    private Map<String, Order> orders = Collections.synchronizedMap(new HashMap<>());

    @CacheResult(cacheName = "orders")
    public List<Order> all() {
        sleep(Duration.ofSeconds(3));
        return new ArrayList<>(this.orders.values());
    }

    @CacheRemoveAll(cacheName = "orders")
    public void create(@CacheValue Order order) {
        this.orders.put(order.getId(), order);
    }

    @CacheRemove(cacheName = "ordersById")
    @CacheRemoveAll(cacheName = "orders")
    public void delete(String orderId) {
        orders.remove(orderId);
    }

    @CachePut(cacheName = "ordersById")
    public Order byId(String orderId) {
        sleep(Duration.ofSeconds(2));
        return this.orders.get(orderId);
    }

    private void sleep(Duration duration) {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            Logger.getAnonymousLogger().severe(e.getLocalizedMessage());
        }
    }

}
