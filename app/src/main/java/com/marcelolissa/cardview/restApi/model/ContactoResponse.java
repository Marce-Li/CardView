package com.marcelolissa.cardview.restApi.model;

import com.marcelolissa.cardview.pojo.Contactos;

import java.util.ArrayList;

public class ContactoResponse {

    ArrayList<Contactos> contactos;

    public ArrayList<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contactos> contactos) {
        this.contactos = contactos;
    }
}
