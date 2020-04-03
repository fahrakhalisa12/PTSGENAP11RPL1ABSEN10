package com.example.ptsgenap11rpl1absen10;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListBarangAdapter extends RecyclerView.Adapter<ListBarangAdapter.ViewHolder> {
    private Context mctx;
    private List<DataBarang> dataBarang; //inisialisasi List dengan object DataMahasiswa


    //construktor ListMahasiswaAdapter
    public ListBarangAdapter(ReadAllActivity readAllActivity, List<DataBarang> dataBarang , Context mctx) {
        this.dataBarang = dataBarang;
        this.mctx = mctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view yang akan digunakan yaitu layout list_mahasiswa_row.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang_row, parent, false);
        ViewHolder holder = new ViewHolder(v); //inisialisasi ViewHolder
        return holder;
    } //fungsi yang dijalankan saat ViewHolder dibuat

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataBarang data = dataBarang.get(position); //inisialisasi object DataMahasiwa
        holder.b_nama.setText(data.getb_nama()); //menset value view "mNama" sesuai data dari getNamaMahasiswa();
        holder.b_jenis.setText(data.getb_jenis());
        holder.b_kode.setText(data.getb_kode()); //menset value view "mNim" sesuai data dari getNimMahasiswa();
    }

    @Override
    public int getItemCount() {
        return dataBarang.size(); //mengambil item sesuai urutan
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView b_nama, b_jenis, b_kode; //inisialisasi variabel

        public ViewHolder(View itemView) {
            super(itemView);
            b_nama = itemView.findViewById(R.id.textListMahasiswaNama); //find layout sesuai dengan yg di list_mahasiswa_row.xml
            b_jenis = itemView.findViewById(R.id.textListMahasiswaNim);
            b_kode = itemView.findViewById(R.id.textListMahasiswaKode);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mctx,"Kamu memilih "+dataBarang.get(getAdapterPosition()).getb_nama() , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(mctx, DetailActivity.class);

                    i.putExtra("events", dataBarang.get(getAdapterPosition()).getb_id());
                    i.putExtra("events2", dataBarang.get(getAdapterPosition()).getb_kode());
                    i.putExtra("events3", dataBarang.get(getAdapterPosition()).getb_nama());
                    i.putExtra("events4", dataBarang.get(getAdapterPosition()).getb_jenis());
                    mctx.startActivity(i);
                }
            });
            //find layout sesuai dengan yg di list_mahasiswa_row.xml
        }

    }
}
