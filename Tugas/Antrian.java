package Tugas;

public class Antrian {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahDiproses;

    public Antrian(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        sudahDiproses = 0;
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public boolean IsFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (IsFull()) {
            System.out.println("Antrian penuh, tidak bisa menambah mahasiswa.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian.");
    }

    public Mahasiswa[] prosesKRS() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }

        if (sudahDiproses >= 30) {
            System.out.println("Sudah mencapai batas maksimum proses KRS (30 mahasiswa).");
            return null;
        }

        Mahasiswa[] hasil = new Mahasiswa[2];
        int diproses = 0;

        for (int i = 0; i < 2 && !IsEmpty() && sudahDiproses < 30; i++) {
            hasil[i] = data[front];
            front = (front + 1) % max;
            size--;
            sudahDiproses++;
            diproses++;
        }

        for (int i = diproses; i < 2; i++) {
            hasil[i] = null;
        }

        return hasil;
    }

    public void tampilkanDuaTerdepan() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("2 Mahasiswa Terdepan:");
        for (int i = 0; i < 2 && i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa terakhir:");
            data[rear].tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (IsEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa Dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanStatistik() {
        System.out.println("Jumlah mahasiswa dalam antrian : " + size);
        System.out.println("Jumlah yang sudah proses KRS  : " + sudahDiproses);
        System.out.println("Jumlah yang belum diproses    : " + (30 - sudahDiproses));
    }
}
