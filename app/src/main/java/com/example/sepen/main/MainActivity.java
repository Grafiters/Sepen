package com.example.sepen.main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sepen.R;
import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.data_penduduk;
import com.example.sepen.editor.inputPenduduk;
import com.example.sepen.model.Penduduk;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView user, resultkeluarga, resultpenduduk, reslutKelurahan;
    String user1;
    int result1, totalPenduduk, totalkeluarga, totalKelurahan;
    Button input, show, login;
    List<Penduduk> penduduk = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (Button)findViewById(R.id.input);
        show = (Button)findViewById(R.id.show);
        login = (Button)findViewById(R.id.login);
        user = (TextView)findViewById(R.id.user);
        resultkeluarga = (TextView)findViewById(R.id.resultkeluarga);
        resultpenduduk = (TextView)findViewById(R.id.resultpenduduk);
        reslutKelurahan = (TextView)findViewById(R.id.resultkelurahan);

        user1=getIntent().getExtras().getString("");
        user.setText(user1);

//        long count;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            count = penduduk.stream().filter(o-> Boolean.parseBoolean(o.getKelurahan())).mapToInt(Penduduk::getHitung).count();
//            reslutKelurahan.setText(Double.toString(count));
//        }

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            totalPenduduk = penduduk.stream().filter(o -> o.getJml_penduduk()>10).mapToInt(Penduduk::getJml_penduduk).sum();
//            resultpenduduk.setText(Integer.toString(totalPenduduk));
//        }
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            totalkeluarga= penduduk.stream().filter(o -> o.getK_keluarga()>10).mapToInt(Penduduk::getK_keluarga).sum();
//            resultkeluarga.setText(Integer.toString(totalkeluarga));
//        }

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, inputPenduduk.class);
                user1=user.getText().toString();
                i.putExtra("",user1);
                startActivity(i);
                finish();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, data_penduduk.class);
                startActivity(i);
            }
        });

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Penduduk>> call = apiInterface.getData();
        call.enqueue(new Callback<List<Penduduk>>() {
            @Override
            public void onResponse(Call<List<Penduduk>> call, Response<List<Penduduk>> response) {
                if (response.isSuccessful() && response.body() != null){
                    result1=response.body().size();
                    for (int i = 0 ; i<result1; i++){
                        totalkeluarga += response.body().get(i).getK_keluarga();
                        totalPenduduk += response.body().get(i).getJml_penduduk();
                        totalKelurahan += 1;
                    }
                    resultkeluarga.setText(Integer.toString(totalkeluarga));
                    resultpenduduk.setText(Integer.toString(totalPenduduk));
                    reslutKelurahan.setText(Integer.toString(totalKelurahan));
                }
            }

            @Override
            public void onFailure(Call<List<Penduduk>> call, Throwable t) {

            }
        });

    }

}
