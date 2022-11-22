package pablo.conejos.chirivella.loginappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private EditText txtUser;
    private EditText txtPassword;
    private Button btnEntrar;

    private SharedPreferences sharedPreferencesRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtUser = findViewById(R.id.txtNombreUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnEntrar = findViewById(R.id.btnEntrarMain);

        sharedPreferencesRegistro = getSharedPreferences(Constantes.REGISTROS,MODE_PRIVATE);


        comprobarRegistro();



        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtUser.getText().toString();
                String pass = txtPassword.getText().toString();


                SharedPreferences.Editor editor = sharedPreferencesRegistro.edit();

                editor.putString(Constantes.NOMBRE, user);
                editor.putString(Constantes.CONTRASENYA,pass);


                editor.apply();


                Intent intent = new Intent(MainActivity.this, Activity2.class);

                startActivity(intent);





            }
        });






    }

    private void comprobarRegistro() {

        String nombre = sharedPreferencesRegistro.getString(Constantes.NOMBRE,"");
        String pass = sharedPreferencesRegistro.getString(Constantes.CONTRASENYA,"");
        if (!nombre.isEmpty() && !pass.isEmpty()){

            Intent intent = new Intent(MainActivity.this, Activity2.class);

            startActivity(intent);
        }

    }


}