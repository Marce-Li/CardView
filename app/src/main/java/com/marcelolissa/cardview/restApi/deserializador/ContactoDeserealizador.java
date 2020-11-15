package com.marcelolissa.cardview.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.marcelolissa.cardview.pojo.Contactos;
import com.marcelolissa.cardview.restApi.JsonKeys;
import com.marcelolissa.cardview.restApi.model.ContactoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactoDeserealizador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setContactos(deserealizarContactoDeJson(contactoResponseData));
        return contactoResponse;
    }

    private ArrayList<Contactos> deserealizarContactoDeJson(JsonArray contactoResponseData){
        ArrayList<Contactos> contactos = new ArrayList<>();
        for (int i = 0; i <contactoResponseData.size() ; i++) {
            JsonObject contactoResponseDataObjet = contactoResponseData.get(i).getAsJsonObject();

            String urlFoto = contactoResponseDataObjet.get(JsonKeys.MEDIA_URL).getAsString();
            String fecha = contactoResponseDataObjet.get(JsonKeys.MEDIA_FECHA).getAsString();
            String dia = fecha.substring(8, 10);
            String mes = fecha.substring(5, 7);
            String año = fecha.substring(0, 4);


            Contactos contactoActual = new Contactos();

            contactoActual.setUrlFoto(urlFoto);
            contactoActual.setFecha(dia + "/" + mes + "/" + año);

            contactos.add(contactoActual);

        }
        return contactos;

    }

}
