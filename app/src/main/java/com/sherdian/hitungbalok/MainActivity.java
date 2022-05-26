package com.sherdian.hitungbalok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etpanjang, etlebar, ettinggi;
    private RadioGroup rgbalok;
    private Button btnhitung, btnreset;
    private TextView tvhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etpanjang = findViewById(R.id.et_panjang);
        etlebar = findViewById(R.id.et_lebar);
        ettinggi = findViewById(R.id.et_tinggi);
        rgbalok = findViewById(R.id.rg_balok);
        btnhitung = findViewById(R.id.btn_hitung);
        btnreset = findViewById(R.id.btn_reset);
        tvhasil = findViewById(R.id.tv_hasil);

        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strpanjang = etpanjang.getText().toString();
                String strlebar = etlebar.getText().toString();
                String strtinggi = ettinggi.getText().toString();

                if (TextUtils.isEmpty(strpanjang)){
                    etpanjang.setError("panjang balok belum diisi!");
                    return;
                }
                if (TextUtils.isEmpty(strlebar)){
                    etlebar.setError("lebar balok belum diisi!");
                    return;
                }
                if (TextUtils.isEmpty(strtinggi)){
                    ettinggi.setError("tinggi balok belum diisi!");
                    return;
                }


                float panjang = Float.parseFloat(strpanjang);
                float lebar = Float.parseFloat(strlebar);
                float tinggi = Float.parseFloat(strtinggi);

                float formulabalok;

                RadioButton radioButton = findViewById(rgbalok.getCheckedRadioButtonId());
                if (radioButton.getText().toString().equalsIgnoreCase("luas")){
                    formulabalok = 2 * (panjang * lebar + lebar * tinggi + panjang * tinggi);
                    tvhasil.setText(String.format("luas balok : %.2f", formulabalok));
                }else{
                    formulabalok = panjang * lebar * tinggi;
                    tvhasil.setText(String.format("volume balok : %.2f", formulabalok));
                }




            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etpanjang.setText("");
                etlebar.setText("");
                ettinggi.setText("");
                tvhasil.setText("");
            }
        });







    }
}