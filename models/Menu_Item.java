package models;
public abstract class Menu_Item {
    int id; 
    String nama;
    int hargabase;
    int stok;
    
    public Menu_Item (int id, String nama, int hargabase, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargabase = hargabase;
        this.status = status;
    }

    abstract double hitungHargaTotal();
    abstract String getOrderDetail();
}


