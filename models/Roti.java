package models;

import java.util.List;
import models.Customizable;

public class Roti extends Menu_Item implements Customizable {
    private int mesesCount = 0;   
    private int gulaCount = 0; 
    private int karamelCount = 0;
    private EnumUkuran ukuran = EnumUkuran.MEDIUM;

    public Roti (int id, String nama, int hargaBase, int stok) {
        super(id, nama, hargaBase, stok);
    }

    @Override
    public void customize(int[] customizations) {
        if (customizations.length >= 4) {
            this.mesesCount = Math.min(Math.max(customizations[1], 0), 5);
            this.gulaCount = Math.min(Math.max(customizations[2], 0), 5);
            this.karamelCount = Math.min(Math.max(customizations[3], 0), 5);
        }
    }

    @Override
    public void customize(List<Integer> customizations) {
        if (customizations != null && customizations.size() >= 4) {
            int[] arr = customizations.stream().mapToInt(i -> i).toArray();
            customize(arr);
        }
    }

    public void setUkuran(EnumUkuran ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public double hitungHargaTotal() {
        int hargaKustomisasi = (mesesCount * 500) + (karamelCount * 3000);
        return hargaBase + ukuran.getTambahanHarga() + hargaKustomisasi;
    }

    @Override
    public String getOrderDetail() {
        return String.format("Roti: %s | Ukuran: %s | Gula: %d, Karamel: %d, Meses: %d | Total: Rp%.2f",
                nama, ukuran, gulaCount, karamelCount, mesesCount, hitungHargaTotal());
    }
}
