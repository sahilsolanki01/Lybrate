package com.solanki.sahil.lybrate.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.solanki.sahil.lybrate.R;
import com.solanki.sahil.lybrate.data.network.Api;
import com.solanki.sahil.lybrate.data.network.Network_Interceptor;
import com.solanki.sahil.lybrate.data.network.RetrofitInstance;
import com.solanki.sahil.lybrate.data.repository.UserRepository;
import com.solanki.sahil.lybrate.databinding.ActivitySearchBinding;
import com.solanki.sahil.lybrate.ui.list.ListActivity;


public class Search extends AppCompatActivity implements SearchListerner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Network_Interceptor network_interceptor = new Network_Interceptor(this);
        Api api = new RetrofitInstance().getApi(network_interceptor);
        UserRepository userRepository = new UserRepository(api);
        SearchViewModelFactory factory = new SearchViewModelFactory(userRepository);

        ActivitySearchBinding bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_search);
        bindingUtil.setViewmodel(ViewModelProviders.of(this, factory).get(SearchViewModel.class));

        bindingUtil.getViewmodel().homeListerner = this;

    }


    @Override
    public void onStarted() {
        Toast.makeText(this, "Loading, Please wait....", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSuccess(LiveData<String> response) {
        response.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent intent = new Intent(Search.this, ListActivity.class);
                intent.putExtra("data", s);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
