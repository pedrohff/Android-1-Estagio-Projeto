package com.example.pedro.projeto1estagio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pedro.projeto1estagio2.core.controllers.ControllerMainActivity;

public class EditarPerfil extends AppCompatActivity {
    private EditText tvEditUsername;
    private EditText tvEditEmail;
    private EditText tvEditPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        tvEditUsername = (EditText)findViewById(R.id.etChangeUsername);
        tvEditEmail = (EditText)findViewById(R.id.etChangeEmail);
        tvEditPhone = (EditText)findViewById(R.id.etChangePhone);
        tvEditUsername.setText(ControllerMainActivity.getInstance().getLogin());
        tvEditEmail.setText(ControllerMainActivity.getInstance().getEmail());
        tvEditPhone.setText(ControllerMainActivity.getInstance().getPhone());
    }

    public void saveProfile(View v){
        ControllerMainActivity.getInstance().setLogin(tvEditUsername.getText().toString());
        ControllerMainActivity.getInstance().setEmail(tvEditEmail.getText().toString());
        ControllerMainActivity.getInstance().setPhone(tvEditPhone.getText().toString());
        Toast.makeText(this, "Informações alteradas", Toast.LENGTH_LONG).show();
        finish();
    }
}
