package com.marcelolissa.cardview.restApiFirebase.adapter;

import com.marcelolissa.cardview.restApiFirebase.ConstantesRestApi;
import com.marcelolissa.cardview.restApiFirebase.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public Endpoints establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Endpoints.class);
    }
}
