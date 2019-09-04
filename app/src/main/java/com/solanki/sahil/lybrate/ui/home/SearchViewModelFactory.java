package com.solanki.sahil.lybrate.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.solanki.sahil.lybrate.data.repository.UserRepository;

public class SearchViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private UserRepository userRepository;


    public SearchViewModelFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SearchViewModel(userRepository);
    }
}
