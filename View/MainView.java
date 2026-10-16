package view;

import controller.OrderController;
import exception.MenuTidakDitemukanException;
import java.util.Scanner;
import models.*;

public class MainView {
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Sistem pemesanan coffeshop");

        System.out.println("\nDaftar Menu:");
        for (Menu_Item item : controller.getMenuList()) {
            System.out.printf("M-0%d: %s (Harga: Rp%d, Stok: %d)\n",
                    item.getId(), item.getNama(), item.getHargaBase(), item.getStok());
        }

        Menu_Item selectedItem = null;
        int jumlah = 0;
    
        while (selectedItem == null) {
            try {
                System.out.print("\nMasukkan menu (1-3): ");
                int id = Integer.parseInt(scanner.nextLine());
                selectedItem = controller.CariMenu(id);
            } catch (MenuTidakDitemukanException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Input nya angkaa");
            }
        }
    }
}