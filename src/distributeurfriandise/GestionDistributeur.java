package distributeurfriandise;

import java.util.Scanner;

/**
 * Classe gérant le menu principal.
 */
class GestionDistributeur {

    
    final static int MIN = 1;
    final static int MAX = 7;
    
    final static int MIN_BONBON = 1;
    final static int MAX_BONBON = 4;
    
    final static int MIN_PARFUM = 1;
    final static int MAX_PARFUM = 6;
    /**
     * Fonction principale.
     *
     * @param args arguments de la ligne de commande
     */
    public static void main(String[] args) {
        
        Distributeur monDistributeur = new Distributeur();
        
        menuDis(monDistributeur);
        
        Magasin monMagasin = new Magasin(10);
        
        Bonbon b5 = new Bonbon("mon bonbobn", Parfum.CHOCOLAT, MIN, MIN);
        b5.afficher();
        menuDis(monDistributeur);
        
    }
    ////////////////////////////////////////////////////////Utilitaire/////////////////////////////////////////////////
    
    /**
     * lis un entier via l'entrée standard 
     * @return retourne l'entier saisie
     */
    static int lireEntier() {
        Scanner sc = new Scanner(System.in);
        int saisie = sc.nextInt();
        return saisie;
    }
    
    /**
      * lis un reel via l'entrée standard 
     * @return retourne l'reel saisie 
     */
    static double lireReel() {
        Scanner sc = new Scanner(System.in);
        double saisie = sc.nextDouble();
        return saisie;
    }
    
    /**
     *  permet de forcer l'utilisateur à saisir un nobre compris dans un intervalle voulu
     * @param min début de l'intervallle
     * @param max fin de l'intervalle
     * @return un nombre compris dans l'intervalle
     */
    static int lireIntervalle(int min , int max){
        int res;
        do {            
            res = lireEntier();
            
            if (res < min || res > max) {
                erreurVal();
            }
        } while (res < min || res > max);
        
        return res;
    }
    
    /**
     *  affichage d'une erreur
     */
    static void erreurVal(){
            System.out.println("Une valeur non valide à été saisie");
    }
    
    /**
     *  demande un entier et retourne le parfum correspondant à l'entier
     * @return un parfum
     */
    static Parfum parfumSelonNum(){
        int res = lireIntervalle(MIN_BONBON, MAX_BONBON);
        Parfum res2 = null;
        return switch (res) {
            case 1 -> Parfum.CARAMEL;
            case 2 -> Parfum.CHOCOLAT;
            case 3 -> Parfum.FRAISE;
            case 4 -> Parfum.NOISETTE;
            case 5 -> Parfum.RIZ;
            case 6 -> Parfum.NOUGAT;
            default -> Parfum.RIZ;
        };
    }
    ////////////////////////////////////////////////Menu du DIS///////////////////////////////////////////////////////////
    ///
    /**
     * le menu du distributeur
     * @param dis l'instance du distributeur sur laquel on va agir
     * enclenche le bonne fonction du distributeur
     */
    static void menuDis(Distributeur dis){
        int rep;
        do {            
            afficherMenu();
            rep = lireIntervalle(MIN,MAX);
            switch (rep) {
                case 1 ->{
                    ajouterBonbon(dis);
                }
                case 2 -> {
                    retirer1Bonbon(dis);
                } 
                case 3 -> {
                retirerXBonbon(dis);
                }
                
                case 4 -> {
                    connaitreNbBonbonDis(dis);
                }
                
                case 5 -> {
                    afficherDis(dis);
                }
                case 6 -> {
                    dessinerDis(dis);
                }
            }
        } while (rep != 7);
    }
    
    
    
    
    /**
     * affichage du texte du menu
     */
    static void afficherMenu(){
        System.out.println("""
                           Que souhaitez-vous faire ?
                           
                           1. Ajouter un bonbon dans le distributeur
                           
                           2. Retirer un bonbon du distributeur
                           
                           3. Retirer x bonbon(s) du distributeur
                           
                           4. Connaitre le nombre de bonbons du distributeur
                           
                           5. Afficher le distributeur
                           
                           6. Dessiner le distributeur
                           
                           7. Quitter
                           
                           
                           """);
    }
    /////////////////////////////////////Entrée Menu////////////////////////////
    
    
/**
 * 
 * @return 
 */
static Bonbon nouveauBonbon(){
            System.out.println("""
                               Veuillez choisir le modèle de bonbons : 
                               1. Chypresers
                               2. Chewing gum (CHOCOLAT)
                               3. Noisettes
                               4. Tigre
                               5. Chewing gum (FRAISE)
                               6. Chewing gum (POMME)
                               
                               """);
            int res = lireIntervalle(MIN_BONBON, MAX_BONBON);
            Bonbon resBonbon = new Bonbon();
            switch (res) {
                case 1 -> {
                     resBonbon = new Bonbon("Chypresers", Parfum.RIZ, 55, 242);
                }
                
                case 2 -> {
                    resBonbon = new Bonbon("Tigre", Parfum.CHOCOLAT, 45, 228);
                }
                
                case 3 -> {
                    resBonbon = new Bonbon("Venus", Parfum.CARAMEL, 45, 228);
                }
                
                case 4 -> {
                     resBonbon = new Bonbon("Noisettes", Parfum.NOISETTE, 50, 250);
                }
                
                case 5 -> {
                    Parfum res2 = parfumSelonNum();
                    
                     resBonbon = new Bonbon("Chewing Gum", res2, 10, 52);
                }
                
            }
            
            
            return resBonbon;
}
    
    static void ajouterBonbon(Distributeur dis){
        dis.ajouterBonbon(nouveauBonbon());
    }
    
    static void retirer1Bonbon(Distributeur dis){
        System.out.println("Vous allez retirer un bonbon");
        dis.retirerBonbon();
    }
    
    static void retirerXBonbon(Distributeur dis){
        System.out.println("Veuillez choisir un nb de bonbon à supprimer");
        int res = lireIntervalle(0, dis.contenu.length);
        dis.retirerBonbons(res);
        
    }
    static void connaitreNbBonbonDis(Distributeur dis){
        System.out.println("Vous avez :" + dis.contenu.length + "Bonbon(s)");
    }
    
    static void afficherDis(Distributeur dis){
        for (int i = 0; i < dis.contenu.length; i++) {
            System.out.println("Bonbon :");
            dis.contenu[i].afficher();
        }
    }
    
    static void dessinerDis(Distributeur dis){
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
   
    
    
    
    
  
    
    
    
    
    
}
