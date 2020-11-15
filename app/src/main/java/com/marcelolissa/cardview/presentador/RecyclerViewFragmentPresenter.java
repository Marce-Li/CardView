package com.marcelolissa.cardview.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.marcelolissa.cardview.db.ConstructorContactos;
import com.marcelolissa.cardview.fragment.IRecyclerViewFragmentView;
import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.restApi.IEndpointsApi;
import com.marcelolissa.cardview.restApi.adapter.RestApiAdapter;
import com.marcelolissa.cardview.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contactos> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactos();
        ObtenerMediosRecientes();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void ObtenerMediosRecientes() {
        //Ejecuta la conexion al servidor
        RestApiAdapter restApiAdapter = new RestApiAdapter();   //Establece conexion con el servidor con el API de Instagram
        Gson gsonMediaResent = restApiAdapter.construyeGsonDeserealizadorMediaRecent(); //Forma en la que queremos deserealizar los datos
        IEndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaResent);    //Establecemos la conexion pasndo la manera en que queremos deserealizar la respuesta

        //Ejecuta la llamada @GET (llamada a la API)
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Error en la conexion", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        //iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iRecyclerViewFragmentView.generarGridLayoutVertical();
    }

}
