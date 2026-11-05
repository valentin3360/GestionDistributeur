/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
/**
 *
 * @author vrioux
 */
public class DistributeurTest {
    
    @Test
    public void inaDistributeurTest(){
        Distributeur d = new Distributeur();
        assertEquals(0, d.nombreBonbons);
        assertNotNull(d.contenu);
        assertEquals(Distributeur.CONTENANCE_MAX, d.contenu.length);
    }
    
    @Test
    public void ajouterDistributeurTest(){
        Bonbon b = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        Distributeur d = new Distributeur();
        assertTrue(d.ajouterBonbon(b));
        
        
        Bonbon c = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        assertTrue(d.ajouterBonbon(c));
        assertTrue(d.ajouterBonbon(b));
        
        Distributeur d2 = new Distributeur(0, 2);
        assertTrue(d2.ajouterBonbon(c));
        assertTrue(d2.ajouterBonbon(b));
        assertFalse(d2.ajouterBonbon(b));
        
        Distributeur d3 = new Distributeur(0, 0);
        assertFalse(d3.ajouterBonbon(b));
        
        
        Distributeur d4 = new Distributeur(0, 1);
        assertTrue(d4.ajouterBonbon(b));
        assertFalse(d4.ajouterBonbon(b));
        
        
    }
    
    @Test
    public void retirerDistributeurTest(){
        Bonbon a = new Bonbon("Lion", Parfum.CHOCOLAT, 100, 140);
        Bonbon b = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        Bonbon c = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        Bonbon[] liBonbon = {a,b,c}; 
        Distributeur dis = new Distributeur(3, liBonbon);
        
        dis.retirerBonbon();
        
        Bonbon[] liBonbon2 = {a,b, null}; 
        
        for (int i = 0; i < dis.contenu.length; i++) {
            assertEquals(liBonbon2[i], dis.contenu[i]);
        }
        
    }
    @Test
    public void retirersDistributeurTest(){
        Bonbon a = new Bonbon("Lion", Parfum.CHOCOLAT, 100, 140);
        Bonbon b = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        Bonbon c = new Bonbon("Tigre", Parfum.FRAISE, 10, 150);
        Bonbon[] liBonbon = {a,b,c}; 
        Distributeur dis = new Distributeur(3, liBonbon);
        
        dis.retirerBonbons(3);
        
        Bonbon[] liBonbon2 = {null, null, null}; 
        
        for (int i = 0; i < dis.contenu.length; i++) {
            assertEquals(liBonbon2[i], dis.contenu[i]);
        }
        
    }
}
