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
public class MagasinTest {
    @Test
    public void testMagasin(){
        Magasin m = new Magasin(7);
    assertNotNull(m.modeles);
    assertEquals(7, m.modeles.length);
    assertNotNull(m.prix);
    assertEquals(7, m.prix.length);
    assertNotNull(m.stock);
    assertEquals(7, m.stock.length);
    }
    
    @Test
    public void testMagasinAjouterBonbon(){
        Magasin m = new Magasin(3);
        
        Bonbon b1 = new Bonbon("", Parfum.CHOCOLAT, 10, 10);
        m.ajouterStock(b1, 100);
        
        assertEquals(b1, m.modeles[0]);
        assertEquals(100, m.stock[0]);
        
        
        
    }
    
        
}
