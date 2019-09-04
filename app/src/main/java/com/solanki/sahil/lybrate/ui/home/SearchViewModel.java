package com.solanki.sahil.lybrate.ui.home;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.solanki.sahil.lybrate.data.repository.UserRepository;

public class SearchViewModel extends ViewModel {
    public String search_text = "";
    public SearchListerner homeListerner;
    private UserRepository userRepository;


    public SearchViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void onButtonClicked(View view) {
        homeListerner.onStarted();

        if (search_text.isEmpty()) {
            homeListerner.onFailure("Enter a query!");
            return;
        } else {
            LiveData<String> response = userRepository.result(search_text);
            homeListerner.onSuccess(response);
        }


    }

}
