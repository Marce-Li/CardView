package com.marcelolissa.cardview.restApiFirebase;

import com.marcelolissa.cardview.restApiFirebase.modelo.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Endpoints {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarUsuario( @Field("id_dispositivo") String id_dispositivo, @Field("id_usuario")
            String id_usuario, @Field("id_foto_instagram") String id_foto_instagram);

    @GET(ConstantesRestApi.KEY_NOTIFICACION)
    Call<UsuarioResponse> notificacion (@Path("id") String id);
}
