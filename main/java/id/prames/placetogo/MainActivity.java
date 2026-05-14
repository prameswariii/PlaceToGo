package id.prames.placetogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnJakarta, btnBogor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJakarta = findViewById(R.id.btnJakarta);
        btnBogor = findViewById(R.id.btnBogor);

        btnJakarta.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KategoriActivity.class);
            intent.putExtra("kota", "Jakarta");
            startActivity(intent);
        });

        btnBogor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, KategoriActivity.class);
            intent.putExtra("kota", "Bogor");
            startActivity(intent);
        });
    }
}