package models;

public abstract class Menu_Item {
    protected int id;
    protected String nama;
    protected int hargaBase;
    protected int stok;

    public Menu_Item(int id, String nama, int hargaBase, int stok) {
        this.id = id;
        this.nama = nama;
        this.hargaBase = hargaBase;
        this.stok = stok;
    }

    public abstract double hitungHargaTotal();
    public abstract String getOrderDetail();

     public double hitungHargaTotal(int jumlah) {
        return hargaBase * jumlah;
    }

    public double hitungHargaTotal(int jumlah, String kodePromo) {
        double total = hitungHargaTotal(jumlah);
        if ("PROMO10".equalsIgnoreCase(kodePromo)) {
            total *= 0.90;
        } else if ("PROMO20".equalsIgnoreCase(kodePromo)) {
            total *= 0.80; 
        }
        return total;
    }

    public double hitungHargaTotal(int jumlah, EnumUkuran ukuran) {
        return (hargaBase + ukuran.getTambahanHarga()) * jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHargaBase() {
        return hargaBase;
    }

    public void setHargaBase(int hargaBase) {
        this.hargaBase = hargaBase;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}



   

   




