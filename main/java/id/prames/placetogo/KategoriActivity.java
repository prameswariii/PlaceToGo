package id.prames.placetogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class KategoriActivity extends AppCompatActivity {

    TextView tvKota;
    Button btnPusatPerbelanjaan, btnKuliner, btnCafe, btnWisata, btnPasar;
    String kota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        tvKota = findViewById(R.id.tvKota);
        btnPusatPerbelanjaan = findViewById(R.id.btnPusatPerbelanjaan);
        btnKuliner = findViewById(R.id.btnKuliner);
        btnCafe = findViewById(R.id.btnCafe);
        btnWisata = findViewById(R.id.btnWisata);
        btnPasar = findViewById(R.id.btnPasar);

        kota = getIntent().getStringExtra("kota");
        tvKota.setText("Pilih Kategori di " + kota);

        btnPusatPerbelanjaan.setOnClickListener(v -> bukaDaftarTempat("Pusat Perbelanjaan"));
        btnKuliner.setOnClickListener(v -> bukaDaftarTempat("Kuliner"));
        btnCafe.setOnClickListener(v -> bukaDaftarTempat("Cafe"));
        btnWisata.setOnClickListener(v -> bukaDaftarTempat("Wisata"));
        btnPasar.setOnClickListener(v -> bukaDaftarTempat("Pasar"));
    }

    private void bukaDaftarTempat(String kategori) {
        Intent intent = new Intent(KategoriActivity.this, DaftarTempatActivity.class);
        intent.putExtra("kota", kota);
        intent.putExtra("kategori", kategori);
        startActivity(intent);
    }
}