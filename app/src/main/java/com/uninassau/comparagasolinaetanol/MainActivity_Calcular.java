package com.uninassau.comparagasolinaetanol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity_Calcular extends AppCompatActivity {

    public static String SAVED_TEXT2 = "savedText";
    TextInputEditText inputGasolina;
    TextInputEditText inputEtanol;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calcular);

    }

    @SuppressLint("WrongViewCast")
    public void comparar(View view) {

        inputGasolina = findViewById(R.id.inputGasolina);
        inputEtanol = findViewById(R.id.inputEtanol);
        textResultado = findViewById(R.id.textResultado);

        Double valorGasolina = Double.parseDouble(inputGasolina.getText().toString());
        Double valorEtanol = Double.parseDouble(inputEtanol.getText().toString());
        Double valorResultado = valorEtanol/valorGasolina;

        if (valorResultado < 0.7) {
            textResultado.setText("É melhor usar álcool.");
//            textResultado.setBackgroundResource(Integer.parseInt(@drawable/etanol");
            textResultado.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }else{
            textResultado.setText("É melhor usar gasolina.");
            textResultado.setBackgroundColor(getResources().getColor(R.color.teal_700));
//            textResultado.setBackground(getDrawable(Integer.parseInt("@drawable/gasolina")));
        }


    }
}
