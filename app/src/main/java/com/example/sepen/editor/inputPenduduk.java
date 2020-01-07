package com.example.sepen.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.model.Penduduk;
import com.example.sepen.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class inputPenduduk extends AppCompatActivity implements editorView {

    EditText prov, kot, kec, kel, w, t, keluarga, penduduk;
    Button submit;
    ProgressDialog progressDialog;
    ApiInterface apiInterface;

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

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait .....");

        presenter = new editorPresenter(this);

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

                presenter.saveNotes(provinsi, kota, kecamatan, kelurahan, rw, rt, k_keluarga, jml_penduduk);
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
        Toast.makeText(inputPenduduk.this, message, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(inputPenduduk.this, message, Toast.LENGTH_SHORT).show();
    }
}
