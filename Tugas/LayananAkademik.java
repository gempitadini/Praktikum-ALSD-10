package Tugas;

import java.util.Scanner;

public class LayananAkademik {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Antrian antrian = new Antrian(10);  
        int pilihan;

        do {
            System.out.println("\n=== MENU LAYANAN AKADEMIK ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses 2 Mahasiswa Terdepan");
            System.out.println("3. Lihat 2 Mahasiswa Terdepan");
            System.out.println("4. Lihat Semua Antrian");
            System.out.println("5. Jumlah Mahasiswa dalam Antrian");
            System.out.println("6. Lihat Mahasiswa Terakhir");
            System.out.println("7. Cek Antrian Kosong");
            System.out.println("8. Cek Antrian Penuh");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("10. Jumlah Mahasiswa Sudah Proses KRS");
            System.out.println("11. Jumlah Mahasiswa Belum Proses KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();  

            switch (pilihan) {
                case 1:
                    if (antrian.IsFull()) {
                        System.out.println("Antrian penuh.");
                        break;
                    }
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    Mahasiswa[] dilayani = antrian.prosesKRS();
                    if (dilayani != null) {
                        System.out.println("Mahasiswa yang diproses:");
                        for (Mahasiswa m : dilayani) {
                            if (m != null)
                                m.tampilkanData();
                        }
                    }
                    break;
                case 3:
                    antrian.tampilkanDuaTerdepan();
                    break;
                case 4:
                    antrian.tampilkanSemua();
                    break;
                case 5:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian.size);
                    break;
                case 6:
                    antrian.lihatAkhir();
                    break;
                case 7:
                    System.out.println(antrian.IsEmpty() ? "Antrian kosong." : "Antrian tidak kosong.");
                    break;
                case 8:
                    System.out.println(antrian.IsFull() ? "Antrian penuh." : "Antrian belum penuh.");
                    break;
                case 9:
                    antrian.clear();
                    break;
                case 10:
                    System.out.println("Jumlah sudah proses KRS: " + antrian.sudahDiproses);
                    break;
                case 11:
                    System.out.println("Jumlah belum proses KRS: " + (30 - antrian.sudahDiproses));
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        sc.close();
    }
}
