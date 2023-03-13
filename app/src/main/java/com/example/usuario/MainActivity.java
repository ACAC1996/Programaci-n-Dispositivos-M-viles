package com.example.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button login, register;
    EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario= findViewById(R.id.txtEmail);
        password=findViewById(R.id.txtPassword);
        login=findViewById(R.id.btnLogin);
        register=findViewById(R.id.btnRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.setError(null);
                password.setError(null);
                if(usuario.getText().toString().equals("")){
                    usuario.setError("Usuario vacío");
                    usuario.requestFocus();
                } else if (usuario.getText().toString().length()<5) {
                    usuario.setError("Usuario inválido");
                    usuario.requestFocus();
                } else {
                    Pattern pattern = Pattern
                            .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                    // El email a validar
                    String email = usuario.getText().toString();

                    Matcher mather = pattern.matcher(email);

                    if (mather.find() == false) {
                        usuario.setError("El email ingresado es inválido.");
                    }
                }
                if(password.getText().toString().equals("")){
                    password.setError("Contraseña vacía");
                    password.requestFocus();
                } else if (password.getText().toString().length()<8) {
                    password.setError("Contraseña inválida");
                    password.requestFocus();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,RegistroUsuario.class);
                startActivity(i);
                finish();
            }
        });
    }
}