package models;

public class Kopi extends Menu_Item implements Customizable{
    public Kopi (int id, String nama, int hargabase, int stok) {
       super(id, nama, hargabase, stok);
    }

    @Override
    public String getOrderDetail() {
        return ("[Smart Door Lock] ID: "+getId() + 
        " | Nama: "+getNama() + 
        " | Daya: "+getDaya()+ 
        " | Status: "+getStatus()+
        " | PIN: "+pin
        );
    }
}
