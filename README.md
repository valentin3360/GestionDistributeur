# GestionDistributeur

Gestion d'un distributeur et d'un magasin de friandises, en Java, en mode console.
Réalisé dans le cadre du module R1.01 (Initiation au développement) du BUT Informatique.

Le menu permet de :

- ajouter un bonbon dans le distributeur (6 modèles et parfums disponibles) ;
- retirer un bonbon, ou plusieurs d'un coup ;
- connaître le nombre de bonbons et afficher le contenu du distributeur.

## Lancer le programme

```bash
javac -d out src/distributeurfriandise/*.java
java -cp out distributeurfriandise.GestionDistributeur
```

## Lancer les tests (JUnit 4)

```bash
javac -cp junit-4.13.2.jar -d out src/distributeurfriandise/*.java test/distributeurfriandise/*.java
java -cp out:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore \
  distributeurfriandise.BonbonTest distributeurfriandise.DistributeurTest distributeurfriandise.MagasinTest
```

Les 9 tests passent.
