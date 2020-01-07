package com.example.sepen.api;

import com.example.sepen.model.Penduduk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("inputData.php")
    Call<Penduduk> simpanData(
            @Field("provinsi")String provinsi,
            @Field("kota")String kota,
            @Field("kecamatan")String kecamatan,
            @Field("kelurahan")String kelurahan,
            @Field("rw")int rw,
            @Field("rt")int rt,
            @Field("k_keluarga")int k_keluarga,
            @Field("jml_penduduk")int jml_penduduk
    );

    @GET("showData.php")
    Call<List<Penduduk>>getData();
}
