package com.ftninformatika.glumcivezba.models;

public class Glumci {
    private int id;
    private String ime;
    private String prezime;
    private String biografija;
    private String fotografija;
    private int ocena;
    private String datumR;
    private String filmovi;

    public Glumci() {
    }

    public Glumci(int id, String ime, String prezime, String biografija, String fotografija, int ocena, String datumR, String filmovi) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.biografija = biografija;
        this.fotografija = fotografija;
        this.ocena = ocena;
        this.datumR = datumR;
        this.filmovi = filmovi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }
    public String getFotografija(){
        return fotografija;
    }
    public void setFotografija(String fotografija){
        this.fotografija = fotografija;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getDatumR() {
        return datumR;
    }

    public void setDatumR(String datumR) {
        this.datumR = datumR;
    }

    public String getFilmovi() {
        return filmovi;
    }

    public void setFilmovi(String filmovi) {
        this.filmovi = filmovi;
    }
}
