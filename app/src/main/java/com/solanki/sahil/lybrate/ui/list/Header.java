package com.solanki.sahil.lybrate.ui.list;

public class Header {
    public String cuisine;
    public int viewType;

    public Header(String cuisine, int viewType) {
        this.cuisine = cuisine;
        this.viewType = viewType;
    }

    public Header() {
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
