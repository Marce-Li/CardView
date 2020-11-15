package com.marcelolissa.cardview.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marcelolissa.cardview.restApi.ConstantesRestApi;
import com.marcelolissa.cardview.restApi.IEndpointsApi;
import com.marcelolissa.cardview.restApi.deserializador.ContactoDeserealizador;
import com.marcelolissa.cardview.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public IEndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(IEndpointsApi.class);
    }

    public Gson construyeGsonDeserealizadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserealizador());
        return gsonBuilder.create();
    }
}
