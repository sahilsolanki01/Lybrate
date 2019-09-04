package com.solanki.sahil.lybrate.ui.list;

import androidx.lifecycle.ViewModel;

public class ListViewModel extends ViewModel {

    public String name, address, cuisine, cost;
    public int view_type;

    public ListViewModel(Items items) {

        this.name = items.name;
        this.address = items.address;
        this.cuisine = items.cuisine;
        this.cost = items.cost;
        this.view_type = items.viewType;

    }

    public ListViewModel() {
    }
}
