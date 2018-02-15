package com.example.u4_ejer_de_parcel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String EXTRA_RESTAURANTE = "RESTAURANTE";
    EditText etNombre, etOpinion;
    Spinner spValoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etOpinion = (EditText)findViewById(R.id.etOpinion);
        spValoracion = (Spinner)findViewById(R.id.spValoracion);

        String [] valoracion = {"","1","2","3","4","5","6","7","8","9","10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, valoracion);
        spValoracion.setAdapter(adapter);
    }//FIN onCreate

    public void clickAceptar (View view){

        String nombre = etNombre.getText().toString();
        String opinion = etOpinion.getText().toString();
        String valor = spValoracion.getSelectedItem().toString();

        if (nombre.equals("") || opinion.equals("") || valor.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos",
                    Toast.LENGTH_SHORT).show();
        }else{

            Restaurante restaurante = new Restaurante(nombre, valor, opinion);

            Intent i = new Intent(getApplicationContext(),
                    RestauranteActivity.class);
            i.putExtra(EXTRA_RESTAURANTE, restaurante);
            startActivity(i);
        }
    }


}//FIN Main Activity
