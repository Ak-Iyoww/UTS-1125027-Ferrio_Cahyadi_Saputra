package controller;

import exception.InputTidakValidException;
import exception.MenuTidakDitemukanException;
import exception.StokTidakCukupException;
import models.*;

import java.util.ArrayList;
import java.util.List;

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
        throw new MenuTidakDitemukanException("Error: ID Menu " + id + " tidak ditemukan!");
    }

    public Menu_Item 
}