package TUGAS4; //program sebelum di refactor

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class HitungUsia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan tanggal lahir (1-31): ");
        int hariLahir = scanner.nextInt();

        System.out.print("Masukkan bulan lahir (1-12): ");
        int bulanLahir = scanner.nextInt();

        System.out.print("Masukkan tahun lahir (misal: 1990): ");
        int tahunLahir = scanner.nextInt();


        LocalDate tanggalLahir = LocalDate.of(tahunLahir, bulanLahir, hariLahir);
        LocalDate sekarang = LocalDate.now();
        Period usia = Period.between(tanggalLahir, sekarang);

        System.out.println("Usia Anda saat ini: " + usia.getYears() + " tahun, " +
                usia.getMonths() + " bulan, dan " + usia.getDays() + " hari.");

        scanner.close();
    }
}
