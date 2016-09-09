package com.example.pedro.projeto1estagio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pedro.projeto1estagio2.core.controllers.ControllerMainActivity;

public class Login extends AppCompatActivity {
    private EditText etUser;
    private EditText etPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = (EditText)findViewById(R.id.etUser);
        etPassword = (EditText)findViewById(R.id.etPassword);
    }
    public void entrar(View v){
        ControllerMainActivity.getInstance().setLogin(etUser.getText().toString());
        Intent i = new Intent(this, Contatos.class);
        startActivity(i);
        finish();
    }
}
