package com.solanki.sahil.lybrate.ui.list;

public class Items {

    public String name, address, cuisine, cost;
    public int viewType;

    public Items(String name, String address, String cuisine, String cost, int viewType) {
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.cost = cost;
        this.viewType = viewType;
    }

    public Items() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
