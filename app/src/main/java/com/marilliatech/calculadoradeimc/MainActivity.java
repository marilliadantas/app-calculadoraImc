package com.marilliatech.calculadoradeimc;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.txtResult);
    }

    public void calcularImc(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        double imc = peso / (altura * altura);
        String imcFormatado = String.format("%.2f", imc);

        if (imc < 18.5) {
            textResultado.setText("IMC = " + imcFormatado + "\nAbaixo do peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            textResultado.setText("IMC = " + imcFormatado + "\nPeso normal");
        } else if (imc >= 25 && imc <= 29.9) {
            textResultado.setText("IMC = " + imcFormatado + "\nSobrepeso");
        } else if (imc >= 30 && imc <= 34.9) {
            textResultado.setText("IMC = " + imcFormatado + "\nObesidade grau 1");
        } else if (imc >= 35 && imc <= 39.9) {
            textResultado.setText("IMC = " + imcFormatado + "\nObesidade grau 2 (Severa)");
        } else if (imc >= 40) {
            textResultado.setText("IMC = " + imcFormatado + "\nObesidade grau 3 (Mórbida)");
        }

        editPeso.setText("");
        editAltura.setText("");

        editPeso.clearFocus();
        editPeso.requestFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editPeso.getWindowToken(), 0);
    }
}