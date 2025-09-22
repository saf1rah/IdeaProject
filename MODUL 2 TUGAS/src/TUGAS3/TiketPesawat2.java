package TUGAS3; //setelah di refactor

public class TiketPesawat2 extends Pemesanan implements TUGAS3.Tiket { //extract interface
        private String nama; //refactoring dengan rename method/variable
        private String asal;
        private String tujuan;
        private double Tiket;
        private double diskon;

        public TiketPesawat2(info info) { //refactoring dengan rename method/variable
            this.nama = info.nama();
            this.asal = info.asal();
            this.tujuan = info.tujuan();
            this.Tiket = info.tiket();
            this.diskon = info.diskon();
        }

        public double hitungBiayaTiket() {
            return Tiket - (Tiket * (diskon / 100));
        }

        public double hitungDiskon() {
            return Tiket * (diskon / 100);
        }

        public void tampilkanInformasi() {
            System.out.println("Nama Penumpang: " + nama);
            System.out.println("Asal: " + asal);
            System.out.println("Tujuan: " + tujuan);
            System.out.println("Harga Tiket: " + Tiket);
            System.out.println("Diskon: " + diskon + "%");
            System.out.println("Biaya Tiket Setelah Diskon: " + hitungBiayaTiket());
            System.out.println("Jumlah Diskon: " + hitungDiskon());
        }
    }

