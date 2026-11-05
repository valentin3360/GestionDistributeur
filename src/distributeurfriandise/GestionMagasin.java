/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;


import static distributeurfriandise.GestionDistributeur.lireIntervalle;


/**
 *
 * @author vrioux
 */
public class GestionMagasin {
    
    
    
    final static int MIN_MAG = 1;
    final static int MAX_MAG = 6;
    
    
    
    ///////////////////////////////////////////MENU MAG///////////////////////////////////////////
    static void afficherMenuMagasin(){
        System.out.println("""
                           1. Traiter une livraison
                           2. Traiter une vente
                           3. Modifier un prix de vente
                           4. Afficher la valeur du stock
                           5. Modifier un modèle de bonbon
                           6. Quitter
                           
                           Votre choix : 
                           """);
        
    }
    
    
    static void menuMagasin(Magasin mag){
        int rep;
        mag.affichageStock();
        do {            
            afficherMenuMagasin();
            rep = lireIntervalle(MIN_MAG,MAX_MAG);
            switch (rep) {
                case 1 ->{
                    traiterLivraison(mag);
                }
                case 2 -> {
                   traiterVente(mag);
                } 
                case 3 -> {
                 modifPrixVente(mag);
                }
                
                case 4 -> {
                    afficherValeurStock(mag);
                }
                
                case 5 -> {
                    modifModeleBonbon(mag);
                }
                case 6 -> {
                    System.out.println("vous quitter");   
                }
            }
        } while (rep != 6);
    }
    
    
    ///////////////////////////////////////////////COMMANDE////////////////////////////////////////////////
    
    /**
     * apppelle la methode pour traiter une livraison
     * @param mag instane du magasin
     */
    static void traiterLivraison(Magasin mag){
        mag.traiterUneLivraison();
    }
    
    static void traiterVente(Magasin mag){
        mag.traiterUneVente();
    }
    
    static void modifPrixVente(Magasin mag){
        
    }
    static void afficherValeurStock(Magasin mag){
        
    }
    static void modifModeleBonbon(Magasin mag){
        
    }
    
}
