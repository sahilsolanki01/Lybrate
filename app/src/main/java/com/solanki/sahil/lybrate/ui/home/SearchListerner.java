package com.solanki.sahil.lybrate.ui.home;

import androidx.lifecycle.LiveData;

public interface SearchListerner {

    void onStarted();
    void onSuccess(LiveData<String> response);
    void onFailure(String message);
}
