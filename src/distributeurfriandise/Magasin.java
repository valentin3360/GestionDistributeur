/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;



/**
 *
 * @author vrioux
 */
public class Magasin {
    final int MAX_TYPE = 7;
    final int ENORME = 10000;
    final int MIN_Q = 1;
    Bonbon[] modeles;
    double[] prix;
    int[] stock;
    
    
    Magasin(){
        
    }
    
    Magasin(int nbModeles){
        this.modeles = new Bonbon[nbModeles];
        this.prix = new double[nbModeles];
        this.stock = new int[nbModeles];
    }
    
    /**
     * methode affichant le stock de chaque produit
     */
    void affichageStock(){
        char etat = ' ';
        
        for (int i = 0; i < this.modeles.length; i++) {
            
            if (this.stock[i] < 100 && this.stock[i] > 20) {
                etat = '~';
            } else if ( this.stock[i] < 20) {
                etat='!';
            }
            
            
            System.out.print("["+etat+"]"+ this.stock[i] + "" + this.modeles[i] );
        }
        
        
    }
    
    /**
     * ajute du stock et un type de bonbon au mag
     * @param b
     * @param nb 
     */
    void ajouterStock(Bonbon b, int nb){
        boolean trouve = false;
        int c = 0;
        
        
        while (!trouve && c < this.stock.length) {
            if (modeles[c] == null) {
                trouve = true;
                this.stock[c] = nb;
                this.modeles[c] = b;
                this.prix[c] = 6;
                
            }
            
        }
    }
    
    /**
     * methode d'instance gerant l'arrivé de bonbon au sein du magasin
     */
    void traiterUneLivraison(){
        System.out.println("""
                           Veuillez choisir le modèle de bonbons : 
                           1. Chypresers
                           2. Chewing gum (CHOCOLAT)
                           3. Noisettes
                           4. Tigre
                           5. Chewing gum (FRAISE)
                           6. Chewing gum (POMME)
                           """);
         Bonbon bonbonChoix;
        int rep = GestionDistributeur.lireIntervalle(1, 6);
       do { 
         bonbonChoix = switch (rep) {
                case 1 ->
                    new Bonbon("", Parfum.CHOCOLAT, 10, 10);
               
                case 2 -> 
                    new Bonbon("", Parfum.CARAMEL, 10, 10);
                
                case 3 -> 
                    new Bonbon("", Parfum.FRAISE, 10, 10);
               
                
                case 4 -> 
                    new Bonbon("", Parfum.NOUGAT, 10, 10);
                
                
                case 5 -> 
                    new Bonbon("", Parfum.NOISETTE, 10, 10);
                
                case 6 -> 
                    new Bonbon("", Parfum.RIZ, 10, 10);
                default -> new Bonbon();
                
            };
        
        } while (rep != MAX_TYPE);
        
       
       System.out.println("veuillez choisir une quantité");
       int poid = GestionDistributeur.lireIntervalle(MIN_Q, ENORME);
        ajouterStock(bonbonChoix, rep);
        
    }
    
    
    
    /**
     * methode d'instance permettant de traiter une vente et de modifier les valeur correspondant au stock et à 
     */
    void traiterUneVente(){
        int c = 0;
        System.out.println("""
                           Veuillez choisir le modèle de bonbons : 
                           1. Chypresers
                           2. Chewing gum (CHOCOLAT)
                           3. Noisettes
                           4. Tigre
                           5. Chewing gum (FRAISE)
                           6. Chewing gum (POMME)
                           """);
         Bonbon bonbonChoix;
        int rep = GestionDistributeur.lireIntervalle(1, 6);
       do { 
         bonbonChoix = switch (rep) {
                case 1 ->
                    new Bonbon("", Parfum.CHOCOLAT, 10, 10);
               
                case 2 -> 
                    new Bonbon("", Parfum.CARAMEL, 10, 10);
                
                case 3 -> 
                    new Bonbon("", Parfum.FRAISE, 10, 10);
               
                
                case 4 -> 
                    new Bonbon("", Parfum.NOUGAT, 10, 10);
                
                
                case 5 -> 
                    new Bonbon("", Parfum.NOISETTE, 10, 10);
                
                case 6 -> 
                    new Bonbon("", Parfum.RIZ, 10, 10);
                default -> new Bonbon();
                
            };
        
        } while (rep != MAX_TYPE);
       
       System.out.println("veuillez choisir une quantité");
       int poid = GestionDistributeur.lireIntervalle(MIN_Q, Integer.MAX_VALUE);
       
        if (peuxRetirer(bonbonChoix, rep)) {
            c = placeBonbonStock(bonbonChoix, poid);
            this.stock[c] = this.stock[c]-poid;
            System.out.println("Vous nous devez : " + this.prix[c]*poid);
            
            if (this.stock[c] == 0) {
                System.out.println("Attention il n'y a plus de bonbon de type : " + this.modeles[c]);
        }
            
        } else {
            c = placeBonbonStock(bonbonChoix, poid);
            System.out.println("vous demander trop de bonbon il y en a : " + this.modeles[c]);
            
        }
       
        
       
        
        
    }
    
    /**
     *  verifie si on peut retirer un certain nombre de bonbon au magasin
     * @param b le bonbon en question a comparer à l'instance
     * @param q la quantité souhaité
     * @return  true si on peut rerirer sinon false
     */
    boolean peuxRetirer(Bonbon b, int q){
        int c = 0;
        boolean trouve = false;
        
        while (!trouve && c < modeles.length) {            
            if (modeles[c].equals(b) && stock[c] >= q ) {
                trouve = true;
                System.out.println("Le bonbon à la quantité souhaiter");
            }
        }
        
        return trouve;
    }
    
    /**
     * methode donnant l'indice du bonbon souhaité dans le stock
     * @param b le bonbon en question a comparer à l'instance
     * @param q la quantité souhaité
     * @return c l'indice du bonbon
     */
    int placeBonbonStock(Bonbon b, int q){
        int c = 0;
        boolean trouve = false;
        
        while (!trouve && c < modeles.length) {            
            if (modeles[c].equals(b) && stock[c] > q ) {
                trouve = true;
                System.out.println("Le bonbon à la quantité souhaiter");
            }
        }
        
        return c;
    }
    

    
    
    void modifPrixVente(){
        
        
        
        
    }
        
}
