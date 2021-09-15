package com.example.momotolabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SingUp extends Activity implements View.OnClickListener {
private EditText nom1,nom2,mail,pass,confpass;
private Button btn1;
    BDHelper admin=new BDHelper(this,"pruebaMomotoLabs.db",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        nom1=findViewById(R.id.nombre1);
        nom2=findViewById(R.id.nombre2);
        mail=findViewById(R.id.email);
        pass=findViewById(R.id.contraseña);
        confpass=findViewById(R.id.Confirmacioncontraseña);

        btn1=findViewById(R.id.btn_iniciar);
        btn1.setOnClickListener(this);

    }
    public void regresar(View view) {
        Intent intent = new Intent(SingUp.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {


        SQLiteDatabase db = admin.getWritableDatabase();

        String nombre1=nom1.getText().toString();
        String nombre2=nom2.getText().toString();
        String email=mail.getText().toString();
        String pass1=pass.getText().toString();;
        String pass2=confpass.getText().toString();


        ContentValues values =new ContentValues();
        values.put("username", nombre1);
        values.put("username2",nombre2);
        values.put("mail", email);
        values.put("clave_user", pass1);

        if (nombre1.isEmpty()){
            nom1.setError("campo obligatorio");
        }else if(nombre2.isEmpty()){
            nom2.setError("campo obligatorio");
        }else if(email.isEmpty()){
            mail.setError("campo obligatorio");
        }else if(pass1.isEmpty()){
            pass.setError("campo obligatorio");
        }else if(pass2.isEmpty()){
            confpass.setError("campo obligatorio");
        }else if(pass2 != pass1){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            pass.setText("");
            confpass.setText("");
        }else{
            db.insert("usuarios", null, values);
            db.close();

            Toast ToastMens= Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT);
            ToastMens.show();

            Intent intent = new Intent(SingUp.this, NotificacionBienvenida.class);
            startActivity(intent);
        }
    }
}