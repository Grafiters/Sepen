package com.example.sepen;

import com.example.sepen.api.ApiClient;
import com.example.sepen.api.ApiInterface;
import com.example.sepen.model.Penduduk;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pendudukPresenter {

    private MainView mainView;

    public pendudukPresenter(MainView mainView){
        this.mainView = mainView;
    }

    void getData(){
        mainView.showLoading();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Penduduk>> call = apiInterface.getData();
        call.enqueue(new Callback<List<Penduduk>>() {
            @Override
            public void onResponse(Call<List<Penduduk>> call, Response<List<Penduduk>> response) {
                mainView.hideLoading();
                if (response.isSuccessful() && response.body() != null){
                    mainView.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Penduduk>> call, Throwable t) {
                mainView.hideLoading();
                mainView.onErrorLoading(t.getLocalizedMessage());
            }
        });

    }

}
