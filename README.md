* [Descripriton](#TUM_LearnJava_ExSheet5)
* [BoardGame](#Mensch_ärger_dich_nicht)
* [Graus Gauss]()


# TUM_LearnJava_ExSheet5
Mensch ärger dich nicht: board game. Matrix calculations. 

# Mensch_ärger_dich_nicht

The class extends the MiniJava class with a methode int dice(), which is returns a randome number between 1 and 6 both inkl.
There are two players. The target of every player is to bring all his figures from the house to the garten. The game board is represented of one ring mit 0-39 fields. Every 10 fields there is a fork leading wither into the garten or to further around the ring. 

Game rules:

- every player has 4 game pieces which are placed in the house at the beginning;
- the players start on the position 0 and 10
- after field num. 39 comes field num. 0
- dice is thrown in turns. A player moves his piece the corresponding fields forward
- the one who brings all pieces to his garten first wins
- two pieces can not be place on one field at one time
- a piece of an opponent can be thrown away. If one's last step is the fiels where enemy piece is placed, enemy piece hat to be returned to the house
- if a field is occupied thith a pice of the player that move is on, one cannot make the move.

To play open the class Mensch.java

# Graus_Gauss

in this exersice is a lighter version of [Gaussian elimination](https://en.wikipedia.org/wiki/Gaussian_elimination) implimentiert. "In linear algebra, Gaussian elimination (also known as row reduction) is an algorithm for solving systems of linear equations. It is usually understood as a sequence of operations performed on the corresponding matrix of coefficients. This method can also be used to find the rank of a matrix, to calculate the determinant of a matrix, and to calculate the inverse of an invertible square matrix. The method is named after Carl Friedrich Gauss (1777–1855), although it was known to Chinese mathematicians as early as 179 A.D." Wickipedia

Das Gleichungssystem wird als sog. erweiterte Koeffizientenmatrix eingelesen und vom Programm verwaltet. Es sei z.B. folgendes Gleichungssystem A ∗ x = b gegeben:
x1 +2x2 +3x3 = 2
x1 + x2 + x3 = 2 
3x1+3x2+ x3 = 0

Die erweiterte Koeffizientenmatrix enthält die Koeffizienten A und den b-Vektor:

(1 2 3 2)
(1 1 1 2) 
(3 3 1 0)

Die Matrix hat in dieser Aufgabe immer genau eine Spalte mehr als Zeilen. Im Rahmen des Gaußschen Verfahrens muss die Matrix nun in die sog. Zeilenstufenform überführt werden. In Zeilenstufenform befinden sich unterhalb der Diagonalen des vorderen Teils der Matrix nur 0er; für den Spezialfall von drei Gleichungen hat die Matrix in Zeilenstufenform also die folgende Form:

(··· ··· ··· ···) 
( 0  ··· ··· ···)
( 0   0  ··· ···)

Die Zeilenstufenform wird durch eine Reihe von Umformungen erreicht, die weiter unten genauer beschrieben sind. Hier sei zunächst eine gültige Matrix in Zeilenstufenform für obiges Beispiel gegeben:

(1  2  3 2) 
(0 −1 −2 0) 
(0 0 −2 −6)

Die Matrix lässt sich zum besseren Verständnis wieder zurück in die ursprüngliche Schreib- weise eines Gleichungssystems überführen:

x1+2x2+3x3 = 2 
0−x2−2x3 = 0 
0+0−2x3 =−6

Die Lösung (x1 = 5, x2 = −6 und x3 = 3) lässt sich nun einfach von unten nach oben ablesen. Wir überführen eine Matrix in Zeilenstufenform, indem wir folgende Operationen auf der Matrix ausführen:
• Multiplikation einer Zeile mit einem Faktor
Im folgenden Beispiel wird die zweite Zeile der Matrix mit dem Faktor 2 multipli- ziert:
1 2 3 2 1 2 3 2  1 1 1 2  | × 2 =  2 2 2 4  3310 3310
• Addition einer Zeile, die vorher mit einem Faktor multipliziert wird
Im folgenden Beispiel wird die zweite Zeile der Matrix mit dem Faktor −3 multipli- ziert und auf die dritte Zeile addiert:
1 2 3 2 1 2 3 2 1112 ×(−3)=1112 3 3 1 0 ←−+ 0 0 −2 −6
• Vertauschen zweier Zeilen
Im folgenden Beispiel wird die zweite mit der dritten Zeile vertauscht:
1 2 3 2 1 2 3 2  1 1 1 2  ←− =  3 3 1 0  3 3 1 0 ←− 1 1 1 2
Alle gezeigten Operationen können beliebig angewendet werden, da sie die Lösung des beschriebenen Gleichungssystems nicht ändern. Unser Algorithmus folgt schrittweise der Diagonalen der Koeffizientenmatrix von links oben nach rechts unten und führt für jeden Eintrag die folgenden Operationen aus.
   8

1. Ist der Eintrag auf der Diagonalen gleich 0, so wird die Zeile mit einer darunterlie- genden Zeile getauscht, sodass der Eintrag in der Diagonalen nicht mehr gleich 0 ist. Dies ist wegen der Voraussetzung einer eindeutigen Lösung immer möglich.
2. Es müssen nun alle Einträge ei unterhalb des Diagonaleneintrags d in der gleichen
Spalte zu 0 verändert werden. Um dies zu erreichen, berechnen wir für jeden Eintrag
ei das KGV mit d; es sei kgvi = kgv(ei, d). Wir multiplizieren nun die Zeile von ei
mit kgvi und addieren die Zeile von d multipliziert mit −kgvi auf das Ergebnis. Der ei d
entsprechende Eintrag ei hat nun den Wert 0. Es sei z.B. folgende Matrix gegeben:
6 2 3 2  4 2 2 4  3310
Der Algorithmus befindet sich in der ersten Zeile, es ist also d = 6. Um direkt
darunter in der zweiten Zeile eine 0 zu erzeugen, bilden wir zunächst das KGV mit
4, also 12. Die Multiplikation der zweiten Zeile mit 12 = 3 resultiert in folgender
   Matrix:
4
6 2 3 2 6 2 3 2 4 2 2 4 |×3 =12 6 6 12 3310 3310
Die Addition der ersten Zeile multipliziert mit −12 = −2 ergibt eine Matrix, die
 unsere gewünschte Bedingung erfüllt:
6
6 2 3 2     ×(−2) 6 2 3 2 12 6 6 12 ←−+ =0 2 0 8 3310 3310
