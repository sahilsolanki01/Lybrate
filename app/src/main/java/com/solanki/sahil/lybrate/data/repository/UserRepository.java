package com.solanki.sahil.lybrate.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.solanki.sahil.lybrate.data.network.Api;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private Api api;


    public UserRepository(Api api) {
        this.api = api;
    }

    public LiveData<String> result(String search_text) {
        final MutableLiveData<String> resultResponse = new MutableLiveData<>();
        //Api api = RetrofitInstance.getApi();
        Call<ResponseBody> call = api.getResults(search_text, "8bcb8945d044e9916bcb0a777274051a");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        resultResponse.setValue(response.body().string());
                    } catch (IOException e) {
                        resultResponse.setValue(e.getMessage());
                    }
                } else {
                    try {
                        resultResponse.setValue(response.errorBody().string());
                    } catch (IOException e) {
                        resultResponse.setValue(e.getMessage());
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                resultResponse.setValue(t.getMessage());
            }
        });

        return resultResponse;
    }
}
