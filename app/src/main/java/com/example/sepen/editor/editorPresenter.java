package com.example.sepen.editor;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.model.Penduduk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editorPresenter {
    private editorView view;

    public editorPresenter(editorView view){
        this.view = view;
    }
    void saveNotes(final String provinsi, final String kota, final String kecamatan, final String kelurahan, final int rw, final int rt, final int k_keluarga, final int jml_penduduk){
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Penduduk> call = apiInterface.simpanData(provinsi, kota, kecamatan, kelurahan, rw, rt, k_keluarga, jml_penduduk);

        call.enqueue(new Callback<Penduduk>() {
            @Override
            public void onResponse(Call<Penduduk> call, Response<Penduduk> response) {
                view.hideProgress();
                if (response.isSuccessful() && response.body() != null ){
                    Boolean success = response.body().getSuccess();
                    if (success){
                        view.onAddSuccess(response.body().getMessage());
                    }else {
                        view.onAddError(response.body().getMessage());
//                        Toast.makeText(inputPenduduk.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Penduduk> call, @NonNull Throwable t) {
                view.hideProgress();
                view.onAddSuccess(t.getLocalizedMessage());
//                Toast.makeText(inputPenduduk.this, t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
