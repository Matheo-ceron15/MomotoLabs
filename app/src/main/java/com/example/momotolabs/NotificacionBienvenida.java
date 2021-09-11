package com.example.momotolabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificacionBienvenida extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion_bienvenida);


    }

    public void login(View view) {
        Intent intent = new Intent(NotificacionBienvenida.this, MainActivity.class);
        startActivity(intent);
    }
}