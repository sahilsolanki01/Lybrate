package com.solanki.sahil.lybrate.data.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    public Api getApi(Network_Interceptor network_interceptor){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(network_interceptor).build();

        if(retrofit == null){

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl("https://developers.zomato.com/api/v2.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(Api.class);
    }

}
