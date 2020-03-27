
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    
    public KassapaateTest() {
    }
   
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
       paate = new Kassapaate();
       kortti = new Maksukortti(10);
    }

    @Test
    public void KassaAluksiOikein() {
        assertEquals(paate.kassassaRahaa(), 1000, 0);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
    }
    
    @Test
    public void EdullisenLounaanOstoToimii() {
       assertEquals(paate.syoEdullisesti(10), 7, 60);
       assertEquals(paate.edullisiaLounaitaMyyty(), 1);
       assertEquals(paate.kassassaRahaa(), 1002, 40);
    }
    
    @Test
    public void MaukkaanLounaanOstoToimii() {
       assertEquals(paate.syoMaukkaasti(10), 6, 0);
       assertEquals(paate.maukkaitaLounaitaMyyty(), 1);
       assertEquals(paate.kassassaRahaa(), 1004, 0);
    }
    
    @Test
    public void EdullinenEiOnnistuKunEiVaraa() {
        assertEquals(paate.syoEdullisesti(1), 1, 0);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void MaukkaastiEiOnnistuKunEiVaraa() {
        assertEquals(paate.syoMaukkaasti(2), 2, 0);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void MaksuKortiltaRiittaaEdullisesti() {
        assertEquals(paate.syoEdullisesti(kortti), true);
        assertEquals(kortti.saldo(), 7, 60);
        assertEquals(paate.edullisiaLounaitaMyyty(),1);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void MaksuKortiltaRiittaaMaukkaasti() {
        assertEquals(paate.syoMaukkaasti(kortti), true);
        assertEquals(kortti.saldo(), 6, 0);
        assertEquals(paate.maukkaitaLounaitaMyyty(),1);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaEdullisesti() {
        kortti = new Maksukortti(2);
        assertEquals(paate.syoEdullisesti(kortti), false);
        assertEquals(kortti.saldo(), 2, 0);
        assertEquals(paate.edullisiaLounaitaMyyty(), 0);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void KortillaEiOleTarpeeksiRahaaMaukkaasti() {
        kortti = new Maksukortti(2);
        assertEquals(paate.syoMaukkaasti(kortti), false);
        assertEquals(kortti.saldo(), 2, 0);
        assertEquals(paate.maukkaitaLounaitaMyyty(), 0);
        assertEquals(paate.kassassaRahaa(), 1000, 0);
    }
    
    @Test
    public void KortilleLataaminenToimii() {
        paate.lataaRahaaKortille(kortti, 10);
        assertEquals(kortti.saldo(),20,0);
        assertEquals(paate.kassassaRahaa(), 1010,0);
        
        paate.lataaRahaaKortille(kortti, -10);
        assertEquals(kortti.saldo(),20,0);
        assertEquals(paate.kassassaRahaa(), 1010,0);
    }
}
