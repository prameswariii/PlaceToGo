package id.prames.placetogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailTempatActivity extends AppCompatActivity {

    TextView tvNamaDetail, tvLokasiDetail, tvKategoriDetail, tvDeskripsiDetail;
    ImageView imgDetailTempat;
    Button btnMaps;

    String mapsUrl, imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tempat);

        imgDetailTempat = findViewById(R.id.imgDetailTempat);
        tvNamaDetail = findViewById(R.id.tvNamaDetail);
        tvLokasiDetail = findViewById(R.id.tvLokasiDetail);
        tvKategoriDetail = findViewById(R.id.tvKategoriDetail);
        tvDeskripsiDetail = findViewById(R.id.tvDeskripsiDetail);
        btnMaps = findViewById(R.id.btnMaps);

        String nama = getIntent().getStringExtra("nama");
        String lokasi = getIntent().getStringExtra("lokasi");
        String kategori = getIntent().getStringExtra("kategori");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        imageUrl = getIntent().getStringExtra("imageUrl");
        mapsUrl = getIntent().getStringExtra("mapsUrl");

        tvNamaDetail.setText(nama);
        tvLokasiDetail.setText(lokasi);
        tvKategoriDetail.setText(kategori);
        tvDeskripsiDetail.setText(deskripsi);

        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(this)
                    .load(imageUrl)
                    .into(imgDetailTempat);
        }

        btnMaps.setOnClickListener(v -> {
            if (mapsUrl != null && !mapsUrl.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapsUrl));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Link maps belum tersedia", Toast.LENGTH_SHORT).show();
            }
        });
    }
}