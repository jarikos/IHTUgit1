
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    Varasto puoliTaysiVarasto;
    Varasto turhaVarasto;
    Varasto kelvotonVarasto;
    Varasto negatiivinenVarasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
        puoliTaysiVarasto=new Varasto(10,5);
        turhaVarasto=new Varasto(0);
        kelvotonVarasto=new Varasto(0,9);
        negatiivinenVarasto=new Varasto(0,-2);
    }
    
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
        @Test
    public void konstruktoriLuoNegatiivisenVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
        @Test
    public void konstruktoriLuoKelvotmantVaraston() {
        assertEquals(0, kelvotonVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoPuolikkaanVaraston() {
        assertEquals(5, puoliTaysiVarasto.getSaldo(), vertailuTarkkuus);
    }
    
        @Test
    public void konstruktoriLuoTurhanVaraston() {
        assertEquals(0, turhaVarasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    
        @Test
    public void negatiivinenLisaysEiLisaaSaldoa() {
        varasto.lisaaVarastoon(-8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoaLiikaa() {
        varasto.lisaaVarastoon(103);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
        
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void liikaOttaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(100);
 
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
        
    @Test
    public void negatiivinenOttaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(-8);
 
        double saatuMaara = varasto.otaVarastosta(-100);
 
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void tulostaTilanne() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals("saldo = 6.0, vielä tilaa 4.0", varasto.toString());
    }
}