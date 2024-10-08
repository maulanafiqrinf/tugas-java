package polimorfisme;

public class main {
       
    /*
        polimorfisme : ketika sebuah method / fungsi memiliki jumlah
        lebih dari satu dengan  perilaku yang berbeda.
        indikasi : sama namaFungsi, beda parameter, beda output
    */
    
    // fungsi penjumlah 2 angka
    public void penjumlahan(int a, int b) {
        int hasil = a + b;
        System.out.println("hasil : " + hasil);
    }
    
    // fungsi penjumlahan 3 angka
    public void penjumlahan(int a, int b, int c) { 
        int hasil = a + b + c;
        System.out.println("hasil : " + hasil);
    }
    
    public static void main(String[] args) {
        
        main m = new main();
        m.penjumlahan(12, 5); // 17
        m.penjumlahan(12, 2, 2); // 16
        m.penjumlahan(22, 1, 99);
        
        
        
        
    }
    
}

