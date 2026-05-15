package id.prames.placetogo.model;

public class Tempat {
    String nama, lokasi, kategori, deskripsi, imageUrl, mapsUrl;

    public Tempat(String nama, String lokasi, String kategori, String deskripsi, String imageUrl, String mapsUrl) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.imageUrl = imageUrl;
        this.mapsUrl = mapsUrl;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getKategori() {
        return kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getMapsUrl() {
        return mapsUrl;
    }
}