package UTSPPBO;
public class Laptop extends Komputer {
    String jenisBaterai;

    public Laptop(String merk, double kecepatanProsesor, int ukuranMemori, String jenisProsesor, String jenisBaterai) {
        super(merk, kecepatanProsesor, ukuranMemori, jenisProsesor);
        this.jenisBaterai = jenisBaterai;
    }

    public void tampilLaptop() {
        tampilData();
        System.out.println("Jenis Baterai: " + jenisBaterai);
    }
}