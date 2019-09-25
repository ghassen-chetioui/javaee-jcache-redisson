package io.github.cgh.orders.entity;

import java.io.Serializable;
import java.util.UUID;

public class Order implements Serializable {

    private String id = UUID.randomUUID().toString();
    private String itemName;
    private String itemQuantity;

    public Order(String itemName, String itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
