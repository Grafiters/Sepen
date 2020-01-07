package com.example.sepen;

import com.example.sepen.model.Penduduk;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Penduduk> penduduk);
    void onErrorLoading(String message);
}
