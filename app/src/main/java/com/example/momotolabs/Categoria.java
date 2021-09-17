package com.example.momotolabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Categoria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

    }

    public void programing(View view) {

    }

    public void desing(View view) {

    }

    public void regresar(View view) {

        Intent intent = new Intent(Categoria.this, MainActivity.class);
        startActivity(intent);

    }
}