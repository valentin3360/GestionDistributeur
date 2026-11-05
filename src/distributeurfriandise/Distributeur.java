/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;

/**
 *
 * @author vrioux
 */
public class Distributeur {
    final static int CONTENANCE_MAX = 50;
    int nombreBonbons;
    Bonbon[] contenu;

    
    
    /**
     * constructeur de Distributeur
     * @param CenombreBonbons
     * @param Cettecontenance 
     */
        Distributeur(int CenombreBonbons, Bonbon[] Cettecontenance) {
        this.nombreBonbons = CenombreBonbons;
        this.contenu = Cettecontenance;
    }
    /**
     * constructeur de Distributeur
     * @param CenombreBonbons
     * @param tailleContenance 
     */
        Distributeur(int CenombreBonbons, int tailleContenance) {
        this.nombreBonbons = CenombreBonbons;
        this.contenu = new Bonbon[tailleContenance];
    }
    
        /**
         * constructeur par défaut de la classe
         */
        Distributeur(){
            this.nombreBonbons = 0;
            this.contenu = new Bonbon[CONTENANCE_MAX];
        }
        
        /**
         * methode d'instance permettant d'ajouter un bonbon
         * @param b
         * @return un boolean
         */
        boolean ajouterBonbon(Bonbon b){
            int c = 0;
            boolean trouve = false;
            while (!trouve && c < this.contenu.length) {                
                if (this.contenu[c] == null) {
                    trouve = true;
                    this.contenu[c] = b;
                    this.nombreBonbons++;
                }
                c++;
            }
            return trouve;
            }
        
        
        /**
         * méthode d'instance permettant d retirer un unique bonbon
         */
        void retirerBonbon(){
            int c = nombreBonbons;
            
            if(this.nombreBonbons > 0)
            this.contenu[c-1] = null;
            this.nombreBonbons--;
        }
        
        /**
         * methode d'instance permettant de retirer plusieurs bonbons
         * @param nbBonbon 
         */
        void retirerBonbons(int nbBonbon) {
            if(nbBonbon <= this.nombreBonbons){
            for (int i = 0; i < nbBonbon; i++) {
                
                retirerBonbon();
            }
            } else {
                System.out.println("Il n'y a pas assez de bonbon dans le distributeur");

            }
            
        }
            
            
            
        



}
    

