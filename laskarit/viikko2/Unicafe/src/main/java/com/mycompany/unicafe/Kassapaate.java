
package com.mycompany.unicafe;

public class Kassapaate {

    private double kassassaRahaa;
    private int edulliset;
    private int maukkaat;

    public Kassapaate() {
        this.kassassaRahaa = 1000;
    }

    public double syoEdullisesti(double maksu) {
        if (maksu >= 2.40) {
            this.kassassaRahaa = kassassaRahaa + 2.40;
            ++this.edulliset;
            return maksu - 2.40;
        } else {
            return maksu;
        }
    }

    public double syoMaukkaasti(double maksu) {
        if (maksu >= 4.00) {
            this.kassassaRahaa = kassassaRahaa + 4.00;
            this.maukkaat++;
            return maksu - 4.00;
        } else {
            return maksu;
        }
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        if (kortti.saldo() >= 2.40) {
            kortti.otaRahaa(2.40);
            this.edulliset++;
            return true;
        } else {
            return false;
        }
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        if (kortti.saldo() >= 4.00) {
            kortti.otaRahaa(4.00);
            this.maukkaat++;
            return true;
        } else {
            return false;
        }
    }

    public void lataaRahaaKortille(Maksukortti kortti, int summa) {
        if (summa >= 0) {
            kortti.lataaRahaa(summa);
            this.kassassaRahaa += summa;
        } else {
            return;
        }
    }

    public double kassassaRahaa() {
        return kassassaRahaa;
    }

    public int maukkaitaLounaitaMyyty() {
        return maukkaat;
    }

    public int edullisiaLounaitaMyyty() {
        return edulliset;
    }
}