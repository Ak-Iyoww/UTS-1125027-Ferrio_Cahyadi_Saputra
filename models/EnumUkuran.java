package models;

public enum EnumUkuran {
    SMALL(0),
    MEDIUM(3000),
    LARGE(5000);

    private final int tambahanHarga;

    EnumUkuran(int tambahanHarga) {
        this.tambahanHarga = tambahanHarga;
    }

    public int getTambahanHarga() {
        return tambahanHarga;
    }
}