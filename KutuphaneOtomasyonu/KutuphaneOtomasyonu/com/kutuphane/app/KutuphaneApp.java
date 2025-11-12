package com.kutuphane.app;

public class KutuphaneApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
package com.kutuphane.app;

import com.kutuphane.model.Kitap; 
import java.util.ArrayList; 
import java.util.Scanner; 

public class KutuphaneApp {

    private static ArrayList<Kitap> kitapListesi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        kitapListesi.add(new Kitap("Sefiller", "Victor Hugo", "978-0140443084"));
        kitapListesi.add(new Kitap("Suç ve Ceza", "Fyodor Dostoyevski", "978-0140449130"));
        
        System.out.println("--- Kütüphane Otomasyon Sistemine Hoş Geldiniz! ---");
        boolean calisiyor = true;
        
        while (calisiyor) {
            menuGoster();
            String secim = scanner.nextLine();
            
            switch (secim) {
                case "1":
                    kitapEkle();
                    break;
                case "2":
                    kitaplariListele();
                    break;
                case "3":
                    kitapAra(); 
                    break;
                case "4":
                    calisiyor = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen menüdeki numaraları girin.");
            }
        }
        
        System.out.println("Sistemden çıkılıyor. Güle Güle!");
        scanner.close();
    }
    
   

    private static void menuGoster() {
        System.out.println("\nLütfen bir işlem seçin:");
        System.out.println("1. Yeni Kitap Ekle");
        System.out.println("2. Tüm Kitapları Listele");
        System.out.println("3. Başlığa Göre Kitap Ara");
        System.out.println("4. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private static void kitapEkle() {
        System.out.print("Kitap Başlığı: ");
        String baslik = scanner.nextLine();
        System.out.print("Yazar Adı: ");
        String yazar = scanner.nextLine();
        System.out.print("ISBN Numarası: ");
        String isbn = scanner.nextLine();
        
        
        Kitap yeniKitap = new Kitap(baslik, yazar, isbn);
        kitapListesi.add(yeniKitap);
        System.out.println("Kitap başarıyla eklendi: " + yeniKitap.getBaslik());
    }

    private static void kitaplariListele() {
        if (kitapListesi.isEmpty()) {
            System.out.println("Kütüphanede kayıtlı hiçbir kitap bulunmamaktadır.");
            return;
        }
        
        System.out.println("\n--- KÜTÜPHANE ENVANTERİ (" + kitapListesi.size() + " Kitap) ---");
        for (int i = 0; i < kitapListesi.size(); i++) {
            Kitap k = kitapListesi.get(i);
            
            System.out.println((i + 1) + ". " + k.toString()); 
        }
        System.out.println("------------------------------------------");
    }
    
    private static void kitapAra() {
        System.out.print("Aranacak Kitap Başlığını girin: ");
        String arananBaslik = scanner.nextLine().toLowerCase(); 
        boolean bulundu = false;
        
        System.out.println("\n--- ARAMA SONUÇLARI ---");
        
        for (Kitap k : kitapListesi) { // Enhanced For Loop
            
            if (k.getBaslik().toLowerCase().contains(arananBaslik)) { 
                System.out.println(k.toString());
                bulundu = true;
            }
        }
        
        if (!bulundu) {
            System.out.println("'" + arananBaslik + "' başlıklı kitap bulunamadı.");
        }
        System.out.println("------------------------");
    }
}