# fichiers 
la maquette : `maquette.png`

# Réalisation : 
Faire une application android avec 1 seule activité qui affiche la partie GAUCHE (la partie avec les barres de niveaux)
puis commit sur ce git. Si tu me donnes ton git User, je te rajoute sur le Répo, sinon tu dois faire un pull request.


# mission : 
Réaliser la partie GAUCHE de l'écran seulement avec :
- RxAndroid (RxJava2)
- DataBinding si possible mais pas obligatoire (https://developer.android.com/topic/libraries/data-binding/)
- ConstraintLayout

régles de gestions : 
Les barres (Strength, Speed, Defence, etc) vont de 0 a 2000. A chaque fois que la barre est rempli (2000/2000), la barre passe au niveau supérieur (indiqué par le chiffre a droite sur fond noir), et elle est ensuite remise à 0/2000

dans la maquette, ne pas tenir compte des ` (-) 3000 (+) `. Faire seulement un texte ex:'Strength' un bouton '+' et une progressBar en dessous avec l'indicateur de niveau

L'utilisateur à un capital de points (dans la maquette, 'Tags : 3280 pt'). Qu'il peut depenser en cliquant sur les '+' (Ne pas traiter le cas '-' pour l'exercice), ce qui ajoutera 1000 points a la barre correspondante par click (et fera donc varier la barre de progression, par exemple 1000/2000 : 50%)

Les points utilisés sont débités du totals disponibles (Tags).

pour l'exercice : 
Toutes les barres commencent au niveau 1 à 0/2000.
Le nombre de points disponible (Tags) à distribuer au début  est de 5000. Quand le total arrive a 0, les '+' disparaissent. Il n'est pas possible de retirer des points.


Police d'écriture libre
ne pas se soucier du côté "arrondi" du design, fais un écran rectangulaire classique.
tu peux mettre un boutton standard pour les '+'
Ne passes pas trop de temps sur l'exercice. Si c'est trop long, tu peux faire qu'une seule barre.
temps estimé : 1h-3h

Si tu as des questions n'hésites pas 0630022028 (Aurélien)


