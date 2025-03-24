package com.mycompany.bengkel;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        try {
            BengkelOperations operations = new BengkelOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Menu Bengkel ---");
                System.out.println("1. Tambah Servis");
                System.out.println("2. Lihat Semua Servis");
                System.out.println("3. Perbarui Servis");
                System.out.println("4. Hapus Servis");
                System.out.println("5. Tandai Servis Selesai");
                System.out.println("0. Keluar");
                System.out.print("Masukkan pilihan: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan nama pelanggan: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan layanan: ");
                        String layanan = scanner.nextLine();
                        operations.tambahServis(new Bengkel(nama, layanan));
                        break;

                    case 2:
                        System.out.println("Daftar Servis Bengkel:");
                        operations.getServis().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Masukkan ID servis yang ingin diperbarui: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Masukkan nama baru: ");
                        String namaBaru = scanner.nextLine();
                        System.out.print("Masukkan layanan baru: ");
                        String layananBaru = scanner.nextLine();
                        operations.updateServis(updateId, namaBaru, layananBaru);
                        break;

                    case 4:
                        System.out.print("Masukkan ID servis yang ingin dihapus: ");
                        int deleteId = scanner.nextInt();
                        operations.hapusServis(deleteId);
                        break;

                    case 5:
                        System.out.print("Masukkan ID servis yang telah selesai: ");
                        int completeId = scanner.nextInt();
                        operations.tandaiSelesai(completeId);
                        break;

                    case 0:
                        System.out.println("Keluar dari program...");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid! Coba lagi.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
