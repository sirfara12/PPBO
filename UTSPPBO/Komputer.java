package UTSPPBO;

public class Komputer {
    String merk;
    double kecepatanProsesor;  // Changed to double
    int ukuranMemori;
    String jenisProsesor;

    public Komputer(String merk, double kecepatanProsesor, int ukuranMemori, String jenisProsesor) {
        this.merk = merk;
        this.kecepatanProsesor = kecepatanProsesor;
        this.ukuranMemori = ukuranMemori;
        this.jenisProsesor = jenisProsesor;
    }

    public void tampilData() {
        System.out.println("Merk: " + merk);
        System.out.println("Kecepatan Prosesor: " + kecepatanProsesor + " GHz");
        System.out.println("Ukuran Memori: " + ukuranMemori + " GB");
        System.out.println("Jenis Prosesor: " + jenisProsesor);
    }
}