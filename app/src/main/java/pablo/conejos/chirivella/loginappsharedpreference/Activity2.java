package pablo.conejos.chirivella.loginappsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity2 extends AppCompatActivity {


    private ImageButton btnBorrarRegistro;
    private SharedPreferences sharedPreferencesRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        btnBorrarRegistro = findViewById(R.id.btnBorrarRegistro);
        sharedPreferencesRegistro = getSharedPreferences(Constantes.REGISTROS,MODE_PRIVATE);


        btnBorrarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferencesRegistro.edit();
                editor.clear();
                editor.apply();
                finish();
            }
        });

    }
}