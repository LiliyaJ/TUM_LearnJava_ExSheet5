import java.util.Arrays;

public class Test extends MiniJava {
	private static int lines;
	
	public static void main (String[] args){
	
	

		System.out.print(3.3<4&&4>3);
	
	
/*
	public static int[] rowEchelonToResult(int[] matrix) {
		int ergebnisArray [] = new int[lines];
		for (int i = lines; i >= 0 ; i--) {
			double yWert = get(matrix, i, columns-1);
			for (int j = 0; j < columns-1; j++) {
				double xi = get(matrix, i, j);
				if(xi != 0)
				{
					if(ergebnisArray[j] != 0)
					{
						double xiWert = xi * ergebnisArray[j];
						if (xiWert < 0){
						   yWert = yWert + xiWert;
						}else{
							yWert = yWert - xiWert;
						}
					}
				}
			}
			
			double Xaktuell = get(matrix, i, i);
			double ergebnis = yWert / Xaktuell;
			ergebnisArray[i] = (int)ergebnis;

			System.out.println("");
		}

        for(int i=0; i<ergebnisArray.length; i++)
        	System.out.println("x" + (i+1) + " = " +ergebnisArray[i]);
        return ergebnisArray;
	}
		}

	public static void main(String[] args) {
		lines = read("Geben Sie die Anzahl der Gleichungen ein");
		System.out.println(lines);
		int values = lines * (lines + 1);
		int[] input = new int[values];
		for (int i = 0; i < input.length; i++) {
			input[i] = readInt("Please give " + values + " numbers for the matrix");
			values--;
		}
		
	}*/
}
}
