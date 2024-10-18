package UTSPPBO;
public class PC extends Komputer {
    int ukuranMonitor;

    public PC(String merk, double kecepatanProsesor, int ukuranMemori, String jenisProsesor, int ukuranMonitor) {
        super(merk, kecepatanProsesor, ukuranMemori, jenisProsesor);
        this.ukuranMonitor = ukuranMonitor;
    }

    public void tampilPC() {
        tampilData();
        System.out.println("Ukuran Monitor: " + ukuranMonitor + " inci");
    }
}