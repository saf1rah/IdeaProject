import java.util.Scanner;

class Barang {
    String id;
    String nama;

    Barang(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String toString() { //mencetak informasi barang
        return "ID: " + id + ", Nama: " + nama;
    }
}

class QueueBarang {
    private int front, rear, size;
    private Barang[] queue;

    public QueueBarang(int kapasitas) {
        size = kapasitas;
        queue = new Barang[size];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return rear == size;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void tambahBarang(Barang barang) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak bisa menambah barang lagi.");
        } else {
            queue[rear++] = barang;
            System.out.println("Barang berhasil ditambahkan ke antrian.");
        }
    }

    public void kirimBarang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada barang yang bisa dikirim.");
        } else {
            System.out.println("Mengirim barang: " + queue[front]);
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        }
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar Barang dalam Antrian:");
            for (int i = front; i < rear; i++) {
                System.out.println((i - front + 1) + ". " + queue[i]);
            }
        }
    }
}

public class Tugas2 {
    public static void main(String[] args) {
        QueueBarang antrian = new QueueBarang(10);
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== Menu Antrian Pengiriman Barang =====");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Kirim Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID Barang: ");
                    String id = input.nextLine();
                    System.out.print("Masukkan Nama Barang: ");
                    String nama = input.nextLine();
                    antrian.tambahBarang(new Barang(id, nama));
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    antrian.kirimBarang();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        input.close();
    }
}
