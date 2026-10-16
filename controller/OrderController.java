package controller;

import exception.InputTidakValidException;
import exception.MenuTidakDitemukanException;
import exception.StokTidakCukupException;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class OrderController {
    private List<Menu_Item> menuList;
    public OrderController() {
        menuList = new ArrayList<>();
        menuList.add(new Kopi(1, "Kopi Susu", 18000, 5));
        menuList.add(new Teh(2, "Teh Tarik", 15000, 10));
        menuList.add(new Roti(3, "Roti Cokelat", 12000, 8));
    }
    
    public List<Menu_Item> getMenuList() {
        return menuList;
    }

    public Menu_Item CariMenu(int id) throws MenuTidakDitemukanException {
        for (Menu_Item item : menuList) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new MenuTidakDitemukanException("Error: ID Menu " + id + " ga ketemu mas");
    }

    public void ValidasiPesanan(Menu_Item item, int jumlah) throws InputTidakValidException, StokTidakCukupException {
        if (jumlah <= 0) {
            throw new InputTidakValidException("Error: mau mesen apa kalau 0?");
        }
        if (jumlah > item.getStok()) {
            throw new StokTidakCukupException("Error: stoknya ga cukup dawg, cmn ada : " + item.getStok());
        }
    }

    public void Transaksi(Menu_Item item, int jumlah) {
        item.setStok(item.getStok() - jumlah);
    }
}
