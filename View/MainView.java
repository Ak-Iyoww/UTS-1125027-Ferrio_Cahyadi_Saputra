package view;

import controller.OrderController;
import exception.InputTidakValidException;
import exception.MenuTidakDitemukanException;
import exception.StokTidakCukupException;
import java.util.Scanner;
import models.*;

public class MainView {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistem pemesanan coffeshop");
        System.out.println("\nDaftar Menu: ");
        for (Menu_Item item : controller.getMenuList()) {
            System.out.printf("M-%d: %s (Harga: Rp%d, Stok: %d)\n",
                    item.getId(), item.getNama(), item.getHargaBase(), item.getStok());
        }

        Menu_Item selectedItem = null;
        int jumlah = 0;
    
        while (selectedItem == null) {
            try {
                System.out.print("\nMasukkin menu (pili 1-3): ");
                int id = Integer.parseInt(scanner.nextLine());
                selectedItem = controller.CariMenu(id);
            } catch (MenuTidakDitemukanException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Input nya angkaa");
            }
        }

        boolean validJumlah = false;
        while (!validJumlah) {
            try {
                System.out.print("Masukkin Jumlah Pesanan: ");
                jumlah = Integer.parseInt(scanner.nextLine());
                controller.ValidasiPesanan(selectedItem, jumlah);
                validJumlah = true;
            } catch (InputTidakValidException | StokTidakCukupException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Input nya angka dongg");
            }
        }

        if (selectedItem instanceof Kopi) {
            Kopi kopi = (Kopi) selectedItem;
            System.out.print("Pilih Ukuran : \n1. SMALL \n2. MEDIUM \n3. LARGE ");
            int pilUkuran = Integer.parseInt(scanner.nextLine());
            if (pilUkuran == 1) kopi.setUkuran(EnumUkuran.SMALL);
            else if (pilUkuran == 3) kopi.setUkuran(EnumUkuran.LARGE);

            System.out.println("Kostumisasi Kopi mu !:");
            System.out.print("  Rum 0-1: "); int rum = Integer.parseInt(scanner.nextLine());
            System.out.print("  Es 0-5: "); int es = Integer.parseInt(scanner.nextLine());
            System.out.print("  Gula 0-5: "); int gula = Integer.parseInt(scanner.nextLine());
            System.out.print("  Karamel 0-5: "); int karamel = Integer.parseInt(scanner.nextLine());
            kopi.customize(new int[]{rum, es, gula, karamel});

        } else if (selectedItem instanceof Teh) {
            Teh teh = (Teh) selectedItem;
            System.out.print("Pilih Ukuran : \n1. SMALL \n2. MEDIUM \n3. LARGE ");
            int pilUkuran = Integer.parseInt(scanner.nextLine());
            if (pilUkuran == 1) teh.setUkuran(EnumUkuran.SMALL);
            else if (pilUkuran == 3) teh.setUkuran(EnumUkuran.LARGE);

            System.out.println("Kostumisasi Kopi mu !:");
            System.out.print("  Boba 0-3: "); int boba = Integer.parseInt(scanner.nextLine());
            System.out.print("  Es 0-5: "); int es = Integer.parseInt(scanner.nextLine());
            System.out.print("  Gula 0-5: "); int gula = Integer.parseInt(scanner.nextLine());
            System.out.print("  Karamel 0-5: "); int karamel = Integer.parseInt(scanner.nextLine());
            teh.customize(new int[]{boba, es, gula, karamel});

        } else if (selectedItem instanceof Roti) {
            Roti roti = (Roti) selectedItem;
            System.out.println("Kostumisasi Kopi mu !:");
            System.out.print("  Gula 0-5: "); int gula = Integer.parseInt(scanner.nextLine());
            System.out.print("  Meses 0-5: "); int meses = Integer.parseInt(scanner.nextLine());
            System.out.print("  Karamel 0-5: "); int karamel = Integer.parseInt(scanner.nextLine());
            roti.customize(new int[]{gula, meses, karamel});
        }


        controller.Transaksi(selectedItem, jumlah);
        
        
        System.out.println("\n Struk Pesanan");
        System.out.println(selectedItem.getOrderDetail());
        System.out.println("Jumlah Porsi : " + jumlah);
        System.out.printf("Total Bayar  : Rp%.2f\n", (selectedItem.hitungHargaTotal() * jumlah));
        System.out.println("Sisa Stok    : " + selectedItem.getStok());


        scanner.close();
    }
}