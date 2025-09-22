import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class mengitungUsia {

    /**
     * kelas <kode>hitungUsia2</kode> digunakan untuk menghitung usia seseorang berdasarkan tanggal lahir yang diinputkan oleh pengguna.
     * Menampilkan usia dan hari lahir berdasarkan tanggal lahir.
     */
    public class menghitungUsia {

        /**
         * metode utama yang meminta pengguna untuk memasukkan tanggal, bulan, dan tahun lahir,
         * kemudian menampilkan usia dalam tahun, bulan, dan hari, serta hari dalam seminggu saat pengguna lahir.
         *
         * @param args argumen baris perintah (tidak digunakan disini)
         */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Masukkan tanggal lahir (1-31): ");
            int hariLahir = scanner.nextInt();

            System.out.print("Masukkan bulan lahir (1-12): ");
            int bulanLahir = scanner.nextInt();

            System.out.print("Masukkan tahun lahir (misal: 1990): ");
            int tahunLahir = scanner.nextInt();

            LocalDate tanggalLahir = validasiTanggal(tahunLahir, bulanLahir, hariLahir);
            Period usia = hitungUsia(tanggalLahir);

            System.out.printf("Usia Anda saat ini: %d tahun, %d bulan, dan %d hari.%n",
                    usia.getYears(), usia.getMonths(), usia.getDays());

            // Menampilkan hari dalam seminggu saat pengguna lahir
            String hariLahirDalamMinggu = tentukanHariLahir(tanggalLahir);
            System.out.println("Anda lahir pada hari: " + hariLahirDalamMinggu);
        }

        /**
         * Menghitung usia seseorang berdasarkan tanggal lahir yang diberikan.
         *
         * @param tanggalLahir tanggal lahir yang sudah divalidasi
         * @return objek <code>Period</code> yang mewakili selisih antara tanggal lahir dan tanggal saat ini dalam tahun, bulan, dan hari.
         */
        private static Period hitungUsia(LocalDate tanggalLahir) {
            LocalDate sekarang = LocalDate.now();
            return Period.between(tanggalLahir, sekarang);
        }

        /**
         * Memvalidasi tanggal yang diinputkan oleh pengguna.
         *
         * @param tahunLahir tahun lahir yang diinputkan
         * @param bulanLahir bulan lahir yang diinputkan
         * @param hariLahir hari lahir yang diinputkan
         * @return tanggal lahir dalam format <code>LocalDate</code>
         */
        private static LocalDate validasiTanggal(int tahunLahir, int bulanLahir, int hariLahir) {
            return ambilTanggalLahir(tahunLahir, bulanLahir, hariLahir);
        }

        /**
         * Membuat tanggal lahir dalam bentuk objek <code>LocalDate</code> berdasarkan tahun, bulan, dan hari yang diberikan.
         *
         * @param tahunLahir tahun lahir yang diinputkan
         * @param bulanLahir bulan lahir yang diinputkan
         * @param hariLahir hari lahir yang diinputkan
         * @return tanggal lahir dalam format <code>LocalDate</code>
         */
        private static LocalDate ambilTanggalLahir(int tahunLahir, int bulanLahir, int hariLahir) {
            return LocalDate.of(tahunLahir, bulanLahir, hariLahir);
        }

        /**
         * Menentukan hari dalam seminggu saat pengguna lahir berdasarkan tanggal lahir.
         *
         * @param tanggalLahir tanggal lahir dalam format <code>LocalDate</code>
         * @return nama hari dalam seminggu saat pengguna lahir
         */
        private static String tentukanHariLahir(LocalDate tanggalLahir) { //menerima parameter dlm bentuk localdate
            DayOfWeek hariLahir = tanggalLahir.getDayOfWeek(); //menentukan hari berdasarkan tgl lahir
            return hariLahir.toString();
        }
    }

}
