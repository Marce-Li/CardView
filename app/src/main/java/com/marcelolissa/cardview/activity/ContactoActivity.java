package com.marcelolissa.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marcelolissa.cardview.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static android.widget.Toast.LENGTH_SHORT;

public class ContactoActivity extends AppCompatActivity {

    String correo, correo_dest, mensajeaenviar;
    String contraseña;

    EditText correo_origen;
    EditText contraseñaOrigen;
    EditText correo_destino;
    EditText mensaje;

    Button btnConfirmar, btnMandar;

    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnConfirmar = findViewById(R.id.btnConfirmCorreo);
        btnMandar = findViewById(R.id.btnEnviarCorreo);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("  Petagram");
        getSupportActionBar().setIcon(R.drawable.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo_origen = (EditText) findViewById(R.id.etCorreoOrigen);
                contraseñaOrigen = (EditText) findViewById(R.id.etContraseña);

                correo = correo_origen.getText().toString();
                contraseña = contraseñaOrigen.getText().toString();

                btnMandar.setVisibility(View.VISIBLE);
            }
        });

        btnMandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo_destino = (EditText) findViewById(R.id.etCorreo);
                mensaje = (EditText) findViewById(R.id.etMensajeCorreo);
                correo_dest = correo_destino.getText().toString();
                mensajeaenviar = mensaje.getText().toString();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                //Propiedades del servidor de correo electronico
                Properties propiedades = new Properties();

                //Configuración para el correo de gmail
                propiedades.put("mail.smtp.host", "smtp.gmail.com");        //Servidor de correo electronico
                propiedades.put("mail.smtp.socketFactory.port", "465");     //puerto del socket para recibir respuesta del servidor de gmail
                propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //protocolo de seguridad SSL
                propiedades.put("mail.smtp.auth", "true");      //para autenticarse
                propiedades.put("mail.smtp.port", "465");       //puerto de gmail

                try {
                    session = Session.getDefaultInstance(propiedades, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });

                    if(session!=null){      //Si la sesion no es nula
                        MimeMessage mimeMessage = new MimeMessage(session);     //Crea objeto de tipo mensaje
                        mimeMessage.setFrom(new InternetAddress(correo));       //Carga el correo desde donde se va a enviar
                        mimeMessage.setSubject("Tarea Coursera");               //Carga asunto
                        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(correo_dest));   //Correo que recibe
                        mimeMessage.setText(mensajeaenviar);        //Carga el mensaje
                        Transport.send(mimeMessage);    //Envia el correo
                        btnMandar.setVisibility(View.INVISIBLE);
                        correo_destino.setText("");
                        mensaje.setText("");
                        Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }

    public void boton_enviar(){



    }

}