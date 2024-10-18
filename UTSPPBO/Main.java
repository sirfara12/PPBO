package UTSPPBO;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Mac
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Mac macbook = new Mac("Apple MacBook Pro", 2.4, 16, "Intel Core i7", "Lithium-ion", "Touch ID");
        macbook.tampilMac();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Membuat objek Windows
        Windows pcGaming = new Windows("ASUS ROG", 3.6, 32, "AMD Ryzen 9", 27, "RTX 3080");
        pcGaming.tampilWindows();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Membuat objek PC
        PC pcOffice = new PC("Dell Optiplex", 3.0, 8, "Intel Core i5", 24);
        pcOffice.tampilPC();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
