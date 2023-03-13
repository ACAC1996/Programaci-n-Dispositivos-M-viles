package com.example.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroUsuario extends AppCompatActivity {

    EditText nombre, apellido, email, clave;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nombre=findViewById(R.id.txtNombre);
        apellido=findViewById(R.id.txtApellido);
        email=findViewById(R.id.txtCorreo);
        clave=findViewById(R.id.txtClave);
        registrar=findViewById(R.id.btnRegistrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre.setError(null);
                apellido.setError(null);
                email.setError(null);
                clave.setError(null);

                if(nombre.getText().toString().equals("")){
                    nombre.setError("Nombre vacío");
                    nombre.requestFocus();
                }
                if(apellido.getText().toString().equals("")){
                    apellido.setError("Apellido vacío");
                    apellido.requestFocus();
                }
                if(email.getText().toString().equals("")){
                    email.setError("Email vacío");
                    email.requestFocus();
                } else if (email.getText().toString().length()<5) {
                    email.setError("Email inválido");
                    email.requestFocus();
                } else {
                    Pattern pattern = Pattern
                            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                    // El email a validar
                    String correo = email.getText().toString();

                    Matcher mather = pattern.matcher(correo);

                    if (mather.find() == false) {
                        email.setError("El email ingresado es inválido.");
                    }
                    if(clave.getText().toString().equals("")){
                        clave.setError("Contraseña vacía");
                        clave.requestFocus();
                    } else if (clave.getText().toString().length()<8) {
                        clave.setError("Contraseña inválida");
                        clave.requestFocus();
                    }
                }
            }
        });
    }
}