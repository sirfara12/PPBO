package UTSPPBO;

public class Mac extends Laptop {
    String security;

    public Mac(String merk, double kecepatanProsesor, int ukuranMemori, String jenisProsesor, String jenisBaterai, String security) {
        super(merk, kecepatanProsesor, ukuranMemori, jenisProsesor, jenisBaterai);
        this.security = security;
    }

    public void tampilMac() {
        tampilLaptop();
        System.out.println("Security: " + security);
    }
}

