/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author vrioux
 */
public class BonbonTest {

@Test 
public void testClassBonbon(){
    Bonbon b = new Bonbon("Chypresers", Parfum.NOISETTE, 55, 242);
    assertEquals(Parfum.NOISETTE, b.parfum);
    assertEquals("Chypresers", b.denomination);
    assertEquals(55.0, b.poids, 0.01);
    assertEquals(242.0, b.calories, 0.01);
}

@Test 
public void testMethodeInitiale(){
   Bonbon b = new Bonbon("Chypresers", Parfum.NOISETTE, 55, 242);
    assertEquals(b.initiale(), 'N' );
    b.parfum = Parfum.CARAMEL;
    assertEquals(b.initiale(), 'c' );
    
    b.parfum = Parfum.FRAISE;
    assertEquals(b.initiale(), 'F' );
    
    b.parfum = Parfum.CHOCOLAT;
    assertEquals(b.initiale(), 'C' );
    
    
}

@Test
public void testEquals(){
    Bonbon b = new Bonbon("Tigre", Parfum.CHOCOLAT, 45, 228);
// complètement identiques
assertTrue(b.equals(new Bonbon("Tigre", Parfum.CHOCOLAT, 45, 228)));
// identiques sauf les calories et le poids
assertTrue(b.equals(new Bonbon("Tigre", Parfum.CHOCOLAT, 50, 190)));
// parfum différent
assertFalse(b.equals(new Bonbon("Tigre", Parfum.CARAMEL, 45, 228)));
// Nom différent
assertFalse(b.equals(new Bonbon("Venus", Parfum.CHOCOLAT, 45, 228)));
}

    
}
