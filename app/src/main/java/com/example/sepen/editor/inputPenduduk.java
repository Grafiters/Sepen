package com.example.sepen.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.main.MainActivity;
import com.example.sepen.model.Penduduk;
import com.example.sepen.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class inputPenduduk extends AppCompatActivity implements editorView {

    EditText prov, kot, kec, kel, w, t, keluarga, penduduk;
    TextView tugas;
    Button submit;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;
    String user1;

    editorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_penduduk);

        prov = (EditText)findViewById(R.id.provinsi);
        kot = (EditText)findViewById(R.id.kota);
        kec = (EditText)findViewById(R.id.kecamatan);
        kel = (EditText)findViewById(R.id.kelurahan);
        w = (EditText)findViewById(R.id.rw);
        t = (EditText)findViewById(R.id.rt);
        keluarga = (EditText)findViewById(R.id.k_keluarga);
        penduduk = (EditText)findViewById(R.id.jml_penduduk);
        tugas = (TextView) findViewById(R.id.petugas);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait .....");

        presenter = new editorPresenter(this);

        user1=getIntent().getExtras().getString("");
        tugas.setText(user1);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String provinsi = prov.getText().toString().trim();
                String kota = kot.getText().toString().trim();
                String kecamatan = kec.getText().toString().trim();
                String kelurahan = kel.getText().toString().trim();
                int rw = Integer.parseInt(w.getText().toString().trim());
                int rt = Integer.parseInt(t.getText().toString().trim());
                int k_keluarga = Integer.parseInt(keluarga.getText().toString().trim());
                int jml_penduduk = Integer.parseInt(penduduk.getText().toString().trim());
                String petugas = tugas.getText().toString().trim();

                presenter.saveNotes(provinsi, kota, kecamatan, kelurahan, rw, rt, k_keluarga, jml_penduduk, petugas);
//                saveNotes(provinsi, kota, kecamatan, kelurahan, rw, rt, k_keluarga, jml_penduduk);
            }
        });

    }

    @Override
    public void showProgress() {
         progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onAddSuccess(String message) {
        Toast.makeText(inputPenduduk.this, "success input", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(inputPenduduk.this, MainActivity.class);
        user1=tugas.getText().toString();
        i.putExtra("",user1);
        startActivity(i);
//        finish();
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(inputPenduduk.this, "data error atau sudah ada", Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (event.getAction() == KeyEvent.ACTION_DOWN) {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_BACK:
//                    if (mWebView.canGoBack()) {
//                        mWebView.goBack();
//                    } else {
//                        finish();
//                    }
//                    return true;
//            }
//
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
