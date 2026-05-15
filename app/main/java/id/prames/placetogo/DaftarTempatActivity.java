package id.prames.placetogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

import id.prames.placetogo.adapter.TempatAdapter;
import id.prames.placetogo.model.Tempat;

public class DaftarTempatActivity extends AppCompatActivity {

    TextView tvJudulDaftar, tvEmpty;
    RecyclerView recyclerViewTempat;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_tempat);

        tvJudulDaftar = findViewById(R.id.tvJudulDaftar);
        tvEmpty = findViewById(R.id.tvEmpty);
        recyclerViewTempat = findViewById(R.id.recyclerViewTempat);

        String kota = getIntent().getStringExtra("kota");
        String kategori = getIntent().getStringExtra("kategori");

        tvJudulDaftar.setText(kategori + " di " + kota);

        recyclerViewTempat.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Tempat> list = new ArrayList<>();
        TempatAdapter adapter = new TempatAdapter(list);
        recyclerViewTempat.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();

        db.collection("places")
                .whereEqualTo("lokasi", kota)
                .whereEqualTo("kategori", kategori)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    list.clear();

                    for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                        String nama = document.getString("nama");
                        String lokasi = document.getString("lokasi");
                        String kategoriTempat = document.getString("kategori");
                        String deskripsi = document.getString("deskripsi");
                        String imageUrl = document.getString("imageUrl");
                        String mapsUrl = document.getString("mapsUrl");

                        list.add(new Tempat(
                                nama,
                                lokasi,
                                kategoriTempat,
                                deskripsi,
                                imageUrl,
                                mapsUrl
                        ));
                    }

                    adapter.notifyDataSetChanged();

                    if (list.isEmpty()) {
                        tvEmpty.setVisibility(View.VISIBLE);
                        recyclerViewTempat.setVisibility(View.GONE);
                    } else {
                        tvEmpty.setVisibility(View.GONE);
                        recyclerViewTempat.setVisibility(View.VISIBLE);
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Gagal mengambil data dari Firebase", Toast.LENGTH_SHORT).show();
                });
    }
}