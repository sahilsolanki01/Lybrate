package com.solanki.sahil.lybrate.ui.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solanki.sahil.lybrate.databinding.HeaderBinding;
import com.solanki.sahil.lybrate.databinding.ItemBinding;
import com.solanki.sahil.lybrate.ui.list.Common;
import com.solanki.sahil.lybrate.ui.list.ListViewModel;
import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerView
        .ViewHolder> {

    private ArrayList<ListViewModel> mDataset;
    private LayoutInflater layoutInflater;


    public MyRecyclerViewAdapter(ArrayList<ListViewModel> myDataset) {
        mDataset = myDataset;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater == null)
        {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        if(viewType == Common.ViewType_Header)
        {
            HeaderBinding headerBinding = HeaderBinding.inflate(layoutInflater, parent, false);
            return new HeaderObjectHolder(headerBinding);

        }else if(viewType == Common.ViewType_Item) {
            ItemBinding itemBinding = ItemBinding.inflate(layoutInflater, parent, false);
            return  new DataObjectHolder(itemBinding);
        }
return null;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof HeaderObjectHolder)
        {
            ListViewModel listViewModel = mDataset.get(position);
            ((HeaderObjectHolder) holder).bind(listViewModel);


        }else if(holder instanceof DataObjectHolder) {

            ListViewModel listViewModel = mDataset.get(position);
            ((DataObjectHolder)holder).bind(listViewModel);
        }

    }

    @Override
    public int getItemViewType(int position) {
       return mDataset.get(position).view_type;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        ItemBinding itemBinding;

        public DataObjectHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;

        }

        public void bind(ListViewModel listViewModel)
        {
            this.itemBinding.setList(listViewModel);
        }

        public ItemBinding getItemBinding()
        {
            return itemBinding;
        }


    }

    public static class HeaderObjectHolder extends RecyclerView.ViewHolder {
        HeaderBinding headerBinding;

        public HeaderObjectHolder(HeaderBinding headerBinding) {
            super(headerBinding.getRoot());
            this.headerBinding= headerBinding;

        }

        public void bind(ListViewModel listViewModel)
        {
            this.headerBinding.setHeader(listViewModel);
        }

        public HeaderBinding getItemBinding()
        {
            return headerBinding;
        }


    }
}
