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

For more information please see here
