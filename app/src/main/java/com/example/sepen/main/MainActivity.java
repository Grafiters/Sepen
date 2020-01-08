package com.example.sepen.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sepen.R;
import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.data_penduduk;
import com.example.sepen.editor.inputPenduduk;
import com.example.sepen.login_user;
import com.example.sepen.model.Penduduk;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView user, resultkeluarga;
    String user1, result1;
    Button input, show, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (Button)findViewById(R.id.input);
        show = (Button)findViewById(R.id.show);
        login = (Button)findViewById(R.id.login);
        user = (TextView)findViewById(R.id.user);
        resultkeluarga = (TextView)findViewById(R.id.resultkeluarga);

        user1=getIntent().getExtras().getString("");
        user.setText(user1);

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
    }
}
