
public class GrausGauss extends MiniJava {
	private static int lines;
	private static int columns;

	public static int[] readMatrix() {
		int values = lines * columns;
		int[] input = new int[values];
		for (int i = 0; i < input.length; i++) {
			input[i] = readInt("Bitte geben Sie " + values + " Werte einer Matrix ein");
			values--;
		}
		return input;
	}

	public static void printMatrix(int[] matrix) {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(get(matrix, i, j) + "  ");
			}

			System.out.println("");
		}

		System.out.println("\n");
	}

	//beide Methoden get und set gehen davon aus dass ein User Line- une Columneingabe mit 0 anfängt
	public static int get(int[] matrix, int line, int column) {
		int index = line * columns + column;
		return matrix[index];
	}

	public static int set(int[] matrix, int line, int column, int value) {
		int index = line * columns + column;
		matrix[index] = value;
		return value;
	}
	
	// Verstehe nicht wofür die Methode dient
	public static void multLine(int[] matrix, int line, int factor) {
		for (int i = line * columns; i < line * columns + columns; i++) {
			matrix[i] *= factor;

		}
		printMatrix(matrix);
	}

	public static void multAddLine(int[] matrix, int line, int otherLine, int factor) {

		for (int i = 0; i < columns; i++) {
			// nehmen otherLine Wert und multiplizieren mit dem faktor
			int otherLineWert = get(matrix, otherLine, i);
			otherLineWert = otherLineWert * factor;

			// nehmen line Wert und addieren mit dem Resultat von voner
			int lineWert = get(matrix, line, i);
			lineWert += otherLineWert;
			set(matrix, line, i, lineWert);
		}
		printMatrix(matrix);
	}

	public static void swap(int[] matrix, int lineA, int lineB) {

		int help[] = new int[columns];

		// Zeile merken
		for (int i = 0; i < columns; i++) {
			help[i] = get(matrix, lineA, i);
		}

		// gemerkte Zeile überschreiben durch die andere Zeile
		for (int j = 0; j < columns; j++) {
			int spaltenWert = get(matrix, lineB, j);
			set(matrix, lineA, j, spaltenWert);
		}
		// gemerkte Zeile an Stelle der anderen Zeilen zurück schreiben
		for (int k = 0; k < columns; k++) {
			set(matrix, lineB, k, help[k]);
		}
		printMatrix(matrix);
	}

	public static void searchSwap(int[] matrix, int fromLine) {
		int zeroIndex = (fromLine * columns - fromLine * lines) + fromLine * columns;
		if (matrix[zeroIndex] == 0) {
			int lineA = 0;
			int lineB = 0;
			for (int i = fromLine*columns; i< fromLine*columns+columns; i++){
				lineA = matrix[i]; 
				lineB = matrix[i+columns];
				swap(matrix, lineA,lineB);
			}
		}
	}

	public static int kgv(int a, int b) {
		int resultA = 1;
		int resultB = 1;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			resultA = a * i;
			for (int j = 1; resultB < resultA; j++) {
				resultB = b * j;
			}
			if (resultA == resultB)
				break;
		}
		return (resultA);
	}

	public static int[] rowEchelonToResult(int[] matrix) {

		int line = lines;
		int ergebnisArray[] = new int[lines];
		int resultValue = 0;

		while ((line - 1) >= 0) {
			//bestimmt ein Index und Wert von gesuchten xn
			int unknownValuePosition = ((columns * line - 1) - (columns - line));
			int unknownValue = matrix[unknownValuePosition];

			//bestimmt ein Index und Wert von yn
			int yPosition = columns * line - 1;
			int yValue = matrix[yPosition];

			//findet alle x, die schon bekannt sind, multipliziert mit ensprechenden Wert und addiert zusammen
			int xValueSum = 0;
			int index = lines-1;
				for (int i = matrix.length-1; i >= 0; i--) {
				if (i > unknownValuePosition && i < yPosition) {
					xValueSum += matrix[i] * ergebnisArray[index];
					index--;
					}	
			}
				
			//findet gesuchten xn
			if (line == lines) {
				resultValue = yValue / unknownValue;
			} else {

				int resultTmp = yValue - xValueSum;
				resultValue = resultTmp / unknownValue;

			}
			//speichert xn auf die letzte freie Stelle vom Array
			ergebnisArray[line - 1] = resultValue;
			line--;
		}
		return ergebnisArray;

	}
	//das konnte ich nicht mehr :((
	public static int[] solveSystem(int[] matrix) {
		//1. checking 0 on the diagonal
		int line = lines-1;
		while(line>=0){
		searchSwap(matrix, line);
		line--;
		}
		//2. Checking 0 in the corner
		if (line !=0){
			int start = line*columns;
			int stop = start+1;
			for (int i = start; i < stop; i++){
				if (matrix[i] != 0)
					
				stop++;
			}
		}
		
		return matrix;

	}

	public static void main(String[] args) {
		lines = read("Geben Sie die Anzahl der Gleichungen ein");
		columns = lines + 1;

		
	}
}
