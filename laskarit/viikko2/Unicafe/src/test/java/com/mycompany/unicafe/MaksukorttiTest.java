package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
        
    @Test
    public void saldoOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaaOikein() {
        kortti.lataaRahaa(20);
        assertEquals("saldo: 30.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinKunRahaaTarpeeksi() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuKunRahaaEiTarpeeksi() {
        kortti.otaRahaa(10);
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaaTrue() {
        assertTrue(kortti.otaRahaa(2));
    }
    
    @Test
    public void metodiPalauttaaFalse() {
        assertFalse(kortti.otaRahaa(30));
    }
}
