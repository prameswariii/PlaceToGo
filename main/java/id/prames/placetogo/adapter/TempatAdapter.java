package id.prames.placetogo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import id.prames.placetogo.DetailTempatActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.prames.placetogo.R;
import id.prames.placetogo.model.Tempat;

public class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.ViewHolder> {

    List<Tempat> listTempat;

    public TempatAdapter(List<Tempat> listTempat) {
        this.listTempat = listTempat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tempat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tempat tempat = listTempat.get(position);

        holder.tvNama.setText(tempat.getNama());
        holder.tvLokasi.setText(tempat.getLokasi());
        holder.tvKategori.setText(tempat.getKategori());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailTempatActivity.class);
            intent.putExtra("nama", tempat.getNama());
            intent.putExtra("lokasi", tempat.getLokasi());
            intent.putExtra("kategori", tempat.getKategori());
            intent.putExtra("deskripsi", tempat.getDeskripsi());
            intent.putExtra("imageUrl", tempat.getImageUrl());
            intent.putExtra("mapsUrl", tempat.getMapsUrl());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listTempat.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvLokasi, tvKategori;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvLokasi = itemView.findViewById(R.id.tvLokasi);
            tvKategori = itemView.findViewById(R.id.tvKategori);
        }
    }
}