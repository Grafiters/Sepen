package com.example.sepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.sepen.model.Penduduk;

import java.util.ArrayList;
import java.util.List;

public class data_penduduk extends AppCompatActivity implements MainView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    pendudukPresenter presenter;
    PendudukAdapter adapter;
    PendudukAdapter.ItemClickListener itemClickListener;
    List<Penduduk> penduduks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_penduduk);

        swipeRefreshLayout = findViewById(R.id.refresh);
        recyclerView = findViewById(R.id.recycler_penduduk);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));

        presenter = new pendudukPresenter(this);
        presenter.getData();

        swipeRefreshLayout.setOnRefreshListener(
                ()->presenter.getData()
        );
        itemClickListener = ((view, position)->{
            String provinsi = penduduks.get(position).getProvinsi();
            Toast.makeText(this, provinsi, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<Penduduk> penduduk) {
        adapter = new PendudukAdapter(this, penduduk, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        penduduks = penduduk;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
