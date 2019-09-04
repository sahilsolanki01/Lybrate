package com.solanki.sahil.lybrate.data.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {

    @GET("search")
    Call<ResponseBody> getResults(@Query("q") String userId, @Header("user-key") String token);

}
