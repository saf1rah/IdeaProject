import java.util.Scanner;

public class GabungNama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama depan: ");
        String namaDepan = scanner.nextLine();

        System.out.print("Masukkan nama belakang: ");
        String namaBelakang = scanner.nextLine();

        try {
            String namaLengkap = gabungNama(namaDepan, namaBelakang);
            System.out.println("Nama lengkap: " + namaLengkap);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String gabungNama(String namaDepan, String namaBelakang) {
        if (namaDepan.isEmpty() || namaBelakang.isEmpty()) {
            throw new IllegalArgumentException("Nama depan dan nama belakang harus diisi.");
        }

        if (!namaDepan.matches("[a-zA-Z]+") || !namaBelakang.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Nama hanya boleh mengandung karakter alfabet.");
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(namaDepan).append(" ").append(namaBelakang);
        return stringBuffer.toString();
    }
}
