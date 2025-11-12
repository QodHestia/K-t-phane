package com.kutuphane.model;

public class Kitap {
    
    private String baslik;
    private String yazar;
    private String isbn; 

    
    public Kitap(String baslik, String yazar, String isbn) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.isbn = isbn;
    }

    
    public String getBaslik() {
        return baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public String getIsbn() {
        return isbn;
    }
    
   
    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    
    @Override 
    public String toString() {
        return "Başlık: " + baslik + " | Yazar: " + yazar + " | ISBN: " + isbn;
    }
}