package com.example.u4_ejer_de_parcel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RestauranteActivity extends AppCompatActivity {

    TextView tvNombre, tvOpinion, tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvOpinion = (TextView)findViewById(R.id.tvOpinion);
        tvValor = (TextView)findViewById(R.id.tvValoracion);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            Restaurante r = b.getParcelable(MainActivity.EXTRA_RESTAURANTE);

            tvNombre.setText(r.getNombre());
            tvOpinion.setText(r.getOpinion());
            tvValor.setText(r.getValor());
        }
    }
}
