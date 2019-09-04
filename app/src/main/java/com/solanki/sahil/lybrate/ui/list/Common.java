package com.solanki.sahil.lybrate.ui.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {

    public static final int ViewType_Header = 0;
    public static final int ViewType_Item = 1;

    public static List<String> cuisineAvailabel = new ArrayList<>();

    public static ArrayList<ListViewModel> sortList(ArrayList<ListViewModel> listViewModels) {

        Collections.sort(listViewModels, new Comparator<ListViewModel>() {
            @Override
            public int compare(ListViewModel o1, ListViewModel o2) {
                return o1.cuisine.compareTo(o2.cuisine);
            }
        });
        return listViewModels;
    }

    public static ArrayList<ListViewModel> addCuisine(ArrayList<ListViewModel> list) {
        int i = 0;
        ArrayList<ListViewModel> customList = new ArrayList<>();
        ListViewModel firstPosition = new ListViewModel();
        if (list != null && !list.isEmpty()) {
            firstPosition.cuisine = list.get(0).cuisine;
            firstPosition.view_type = ViewType_Header;
            cuisineAvailabel.add(firstPosition.cuisine);
            customList.add(firstPosition);

            for (i = 0; i < list.size() - 1; i++) {
                ListViewModel listViewModel = new ListViewModel();
                String name1 = list.get(i).cuisine;
                String name2 = list.get(i + 1).cuisine;

                if (name1.equals(name2)) {
                    list.get(i).view_type = ViewType_Item;
                    customList.add(list.get(i));
                } else {
                    list.get(i).view_type = ViewType_Item;
                    customList.add(list.get(i));
                    listViewModel.cuisine = name2;
                    listViewModel.view_type = ViewType_Header;
                    cuisineAvailabel.add(name2);
                    customList.add(listViewModel);
                }
            }

            list.get(i).view_type = ViewType_Item;
            customList.add(list.get(i));
        }

        return customList;

    }

}
