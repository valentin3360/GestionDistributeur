/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributeurfriandise;

/**
 *
 * @author vrioux
 */
public class Bonbon {
    String denomination;
    Parfum parfum;
    double poids;
    double calories;
    
    
    /**
     * convertie un Parfum en son inititiale
     * @return un char correspondant à l'initiale du bonbon
     */
    char initiale(){
        
        char res = ' ';
        switch (this.parfum) {
            case Parfum.CHOCOLAT -> {
                res='C';
            }
            case Parfum.FRAISE -> {
                res='F';
            }
            case Parfum.CARAMEL -> {
                res='c';
            } 
            case Parfum.NOISETTE -> {
                res='N';
            }
        }
        
        
        return res;
        
    }
    
    
    
    /**
     * constructeur de bonbon
     * @param uneDenomination
     * @param unParfum
     * @param unPoids
     * @param desCalories 
     */
    Bonbon(String uneDenomination, Parfum unParfum, double unPoids, double desCalories){
        this.denomination = uneDenomination;
        this.parfum = unParfum;
        this.poids = unPoids;
        this.calories = desCalories;
    }
    
    Bonbon(){
        this.denomination  = "bonbon surprise";
        this.calories = 10.0;
        
    }
    
    /**
     * afiche les caracteristique d'un bobnbon
     */
    void afficher(){
        System.out.println("Ce bon a pour gout : " + Bonbon.this.initiale());
        System.out.println("il est de poid : " + this.poids);
        System.out.println("Est calorifique : " + this.calories);
        System.out.println("est denomier par : " + this.denomination);
    }

    
    /**
     * compare 2 bonbon
     * @param b2 bonbon à comparer à l'insatnce
     * @return boolean selon si ils sont egaux ou non
     */
    boolean equals(Bonbon b2){
        boolean res = false;
        
        if (this.denomination == b2.denomination && this.parfum == b2.parfum) {
            res = true;
        }
        
        
        return res;
    }
    
    
    
}

