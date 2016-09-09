package com.example.pedro.projeto1estagio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.pedro.projeto1estagio2.core.controllers.ControllerMainActivity;

public class Configuracoes extends AppCompatActivity {

    private CheckBox cbShowEmail;
    private CheckBox cbShowFriends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);
        cbShowEmail = (CheckBox)findViewById(R.id.cbShowEmail);
        cbShowFriends = (CheckBox)findViewById(R.id.cbShowFriends);

        cbShowEmail.setChecked(ControllerMainActivity.getInstance().getShowEmail());
        cbShowFriends.setChecked(ControllerMainActivity.getInstance().getShowFriends());
    }

    public void saveConfig(View v){
        ControllerMainActivity.getInstance().setShowEmail(cbShowEmail.isChecked());
        ControllerMainActivity.getInstance().setShowFriends(cbShowFriends.isChecked());
        finish();
    }
}
