package com.example.sepen.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sepen.R;
import com.example.sepen.data_penduduk;
import com.example.sepen.editor.inputPenduduk;
import com.example.sepen.login_user;

public class MainActivity extends AppCompatActivity {

    TextView user;
    String user1;
    Button input, show, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (Button)findViewById(R.id.input);
        show = (Button)findViewById(R.id.show);
        login = (Button)findViewById(R.id.login);
        user = (TextView)findViewById(R.id.user);

        user1=getIntent().getExtras().getString("");
        user.setText(user1);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, inputPenduduk.class);
                startActivity(i);
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
