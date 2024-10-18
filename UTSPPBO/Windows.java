package UTSPPBO;

class Windows extends PC {
    String fitur;

    public Windows(String merk, double kecepatanProsesor, int ukuranMemori, String jenisProsesor, int ukuranMonitor, String fitur) {
        super(merk, kecepatanProsesor, ukuranMemori, jenisProsesor, ukuranMonitor);
        this.fitur = fitur;
    }

    public void tampilWindows() {
        tampilPC();
        System.out.println("Fitur Tambahan: " + fitur);
    }
}