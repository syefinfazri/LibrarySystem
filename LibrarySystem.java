import java.util.LinkedList;
import java.util.Scanner;

class Buku {
    String kode;
    String judul;
    String penulis;

    public Buku(String kode, String judul, String penulis) {
        this.kode = kode;
        this.judul = judul;
        this.penulis = penulis;
    }

    public String toString() {
        return "[" + kode + "] " + judul + " - " + penulis;
    }
}

public class LibrarySystem {

    static LinkedList<Buku> daftarBuku = new LinkedList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== SISTEM DAFTAR BUKU PERPUSTAKAAN ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Update Buku");
            System.out.println("5. Tampilkan Semua Buku");
            System.out.println("6. Hitung Total Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1: tambahBuku(); break;
                case 2: hapusBuku(); break;
                case 3: cariBuku(); break;
                case 4: updateBuku(); break;
                case 5: tampilkanBuku(); break;
                case 6: hitungBuku(); break;
                case 0: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    static void tambahBuku() {
        System.out.print("Masukkan kode buku: ");
        String kode = input.nextLine();
        System.out.print("Masukkan judul buku: ");
        String judul = input.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = input.nextLine();

        daftarBuku.add(new Buku(kode, judul, penulis));
        System.out.println("Buku berhasil ditambahkan!");
    }

    static void hapusBuku() {
        System.out.print("Masukkan kode buku yang akan dihapus: ");
        String kode = input.nextLine();
        
        boolean found = false;
        for (Buku b : daftarBuku) {
            if (b.kode.equalsIgnoreCase(kode)) {
                daftarBuku.remove(b);
                System.out.println("Buku berhasil dihapus!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Buku tidak ditemukan!");
    }

    static void cariBuku() {
        System.out.print("Masukkan judul buku yang dicari: ");
        String judul = input.nextLine();
        
        boolean found = false;
        for (Buku b : daftarBuku) {
            if (b.judul.equalsIgnoreCase(judul)) {
                System.out.println("Ditemukan: " + b);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Buku tidak ditemukan!");
    }

    static void updateBuku() {
        System.out.print("Masukkan kode buku yang akan di-update: ");
        String kode = input.nextLine();
        
        boolean found = false;
        for (Buku b : daftarBuku) {
            if (b.kode.equalsIgnoreCase(kode)) {
                System.out.print("Masukkan judul baru: ");
                b.judul = input.nextLine();
                System.out.print("Masukkan penulis baru: ");
                b.penulis = input.nextLine();
                System.out.println("Data buku berhasil di-update!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Buku tidak ditemukan!");
    }

    static void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku dalam daftar!");
        } else {
            System.out.println("\n=== DAFTAR BUKU ===");
            for (Buku b : daftarBuku) {
                System.out.println(b);
            }
        }
    }

    static void hitungBuku() {
        System.out.println("Total buku dalam daftar: " + daftarBuku.size());
    }
}
