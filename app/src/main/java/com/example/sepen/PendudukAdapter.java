package com.example.sepen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sepen.model.Penduduk;

import java.util.ArrayList;
import java.util.List;

public class PendudukAdapter extends RecyclerView.Adapter<PendudukAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Penduduk> penduduks;
    private ItemClickListener itemClickListener;

    public PendudukAdapter(Context context, List<Penduduk> penduduks, ItemClickListener itemClickListener) {
        this.context = context;
        this.penduduks = penduduks;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.penduduk_layout, parent, false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        Penduduk penduduk = penduduks.get(position);
        holder.prov.setText(penduduk.getProvinsi());
        holder.kot.setText(penduduk.getKota());
        holder.kec.setText(penduduk.getKecamatan());
        holder.kel.setText(penduduk.getKelurahan());
        holder.warga.setText(penduduk.getRw()+"");
        holder.tangga.setText(penduduk.getRt()+"");
        holder.keluarga.setText(penduduk.getK_keluarga()+"");
        holder.penduduk.setText(penduduk.getJml_penduduk()+"");
        holder.tugas.setText(penduduk.getPetugas());
    }

    @Override
    public int getItemCount() {
        return penduduks.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView prov, kot, kec, kel, warga, tangga, keluarga, penduduk, tugas;
        CardView cardView;
        ItemClickListener itemClickListener;
        public RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;

            prov = itemView.findViewById(R.id.provinsi);
            kot = itemView.findViewById(R.id.kota);
            kec = itemView.findViewById(R.id.kecamatan);
            kel = itemView.findViewById(R.id.kelurahan);
            warga = itemView.findViewById(R.id.rw);
            tangga = itemView.findViewById(R.id.rt);
            keluarga = itemView.findViewById(R.id.k_keluarga);
            penduduk = itemView.findViewById(R.id.jml_penduduk);
            tugas = itemView.findViewById(R.id.tugas1);

            cardView = itemView.findViewById(R.id.card_item);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
