package com.example.momotolabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SingUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

    }

    public void regresar(View view) {

        Intent intent = new Intent(SingUp.this, MainActivity.class);
        startActivity(intent);
    }


    public void notificacionBienve(View view) {
        Intent intent = new Intent(SingUp.this, NotificacionBienvenida.class);
        startActivity(intent);
    }
}