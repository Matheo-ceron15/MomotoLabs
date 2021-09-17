    package com.example.momotolabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class MainActivity extends Activity {
        private EditText mail, pass1;
        private Cursor fila;
        BDHelper admin=new BDHelper(this,"pruebaMomotoLabs.db",null,1);
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mail =findViewById(R.id.email);
        pass1=findViewById(R.id.et_password);
    }

        public void nuevaCuenta(View view) {

            Intent intent = new Intent(MainActivity.this, SingUp.class);
            startActivity(intent);
        }

        public void IniciarSesion(View v){
            SQLiteDatabase db=admin.getWritableDatabase();
            String usuario=mail.getText().toString();
            String contrasena=pass1.getText().toString();
            fila=db.rawQuery("select mail,clave_user from usuarios where mail='"+usuario+
                    "' and clave_user='"+contrasena+"'",null);
            try {
                if(fila.moveToFirst()){
                    String usua=fila.getString(0);
                    String pass=fila.getString(1);
                    if (usuario.equals(usua)&&contrasena.equals(pass)){
                        Intent ven=new Intent(this, Categoria.class);
                        startActivity(ven);

                        mail.setText("");
                        pass1.setText("");
                    }
                }else if (usuario.isEmpty()){
                    mail.setError("Campo obligatorio");
                }else if(contrasena.isEmpty()){
                    pass1.setError("Campo obligatorio");
                }
                else {
                    Toast toast=Toast.makeText(this,"Usuario y/o contraseña erroneos",Toast.LENGTH_LONG);
                    //mostramos el toast
                    toast.show();
                }
            } catch (Exception e) {
                Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);
                toast.show();
            }

        }

    }