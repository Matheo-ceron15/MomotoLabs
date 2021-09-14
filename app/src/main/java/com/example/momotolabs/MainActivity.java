    package com.example.momotolabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class MainActivity extends Activity {
        private EditText mail, pass;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass=findViewById(R.id.et_password);
        mail =findViewById(R.id.email);

    }

        public void nuevaCuenta(View view) {

            Intent intent = new Intent(MainActivity.this, SingUp.class);
            startActivity(intent);
        }

        public void categorias(View view) {
            String contra = pass.getText().toString();
            String email = mail.getText().toString();

            if (email.isEmpty()){
                mail.setError("campo obligatorio");
            }else if(contra.isEmpty()){
                pass.setError("campo obligatorio");
            }else{
                Intent intent = new Intent(MainActivity.this, Categoria.class);
                startActivity(intent);
            }
        }
    }