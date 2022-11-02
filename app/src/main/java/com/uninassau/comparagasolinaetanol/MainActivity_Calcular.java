package com.uninassau.comparagasolinaetanol;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.uninassau.comparagasolinaetanol.R;

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView result = findViewById(R.id.textResultado);
        CharSequence savedText = result.getText();
        outState.putCharSequence(SAVED_TEXT2, savedText);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final TextView result = findViewById(R.id.textResultado);
        CharSequence savedText = savedInstanceState.getCharSequence(SAVED_TEXT2);
        result.setText(savedText);
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
            textResultado.setText("\n\n\nÉ melhor usar álcool.");
//            textResultado.setBackgroundResource(Integer.parseInt(@drawable/etanol");
//            textResultado.setBackgroundColor(getResources().getColor(R.color.purple_200));
        }else{
            textResultado.setText("\n\n\nÉ melhor usar gasolina.");
//            textResultado.setBackgroundColor(getResources().getColor(R.color.teal_700));
//            textResultado.setBackground(getDrawable(Integer.parseInt("@drawable/gasolina")));
        }


    }
}
