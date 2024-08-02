package me.sangca.itemdbserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity(name = "serialized_item_stack")
public class SerializedItemStack implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "item_category")
    private String category;

    @Column(name = "item_key")
    private String key;

    private String itemStackAsString;

    public SerializedItemStack() {}

    public SerializedItemStack(String category, String key, String itemStackAsString) {
        this.category = category;
        this.key = key;
        this.itemStackAsString = itemStackAsString;
    }

    public String getCategory() {
        return category;
    }

    public String getKey() {
        return key;
    }

    public String getItemStackAsString() {
        return itemStackAsString;
    }
}
