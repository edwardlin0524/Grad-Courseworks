/* 
 * Student name: Edward Lin
 * Student ID: #1942366
 * assignment name: LCSv2.java
 * */

public class LCSv2 {

	/* Returning two table in a method */
	static class tablePair {
		private String[][] bTable;
		private int[][] cTable;

		/* constructor */
		public tablePair(String[][] bTable, int[][] cTable) {
			this.bTable = bTable;
			this.cTable = cTable;
		}

		public String[][] getbTable() {
			return bTable;
		}

		public int[][] getcTable() {
			return cTable;
		}

	}

	public static void main(String[] args) {
		String A = "ABCBDAB";
		String B = "BDCABA";
		tablePair result = FindLCS(A, B, A.length(), B.length());
		System.out.println("This is Edward Lin's (#1942366) LCSv2.java");
		System.out.println(" ");
		System.out.println("The length of LCS between " + A + " & " + B + " is: "
				+ result.cTable[A.length()][B.length()]);
		System.out.print("The string of LCS is: ");
		printLCS(result.bTable, A, A.length(), B.length());
	}

	static tablePair FindLCS(String A, String B, int ALength, int BLength) {

		/* String length */
		int Alength = A.length();
		int Blength = B.length();

		String[][] bTable = new String[ALength + 1][BLength + 1];
		int[][] cTable = new int[ALength + 1][BLength + 1];

		/* +1 means the position for storing \0 */
		/* following codes would be easy to understand if reading it with table */
		for (int i = 0; i <= Alength; i++) {
			/* Make first row 0 */
			for (int j = 0; j <= Blength; j++) {
				/* Make first column 0 */
				if (i == 0 || j == 0) {
					cTable[i][j] = 0;
				}
				/*
				 * If these two numbers are same, add the number in upper left plus 1 into
				 * current index
				 */
				else if (A.charAt(i - 1) == B.charAt(j - 1)) {
					cTable[i][j] = cTable[i - 1][j - 1] + 1;
					bTable[i][j] = "NW";
				}
				/*
				 * if Left value >= Top value, current value equals to top(or left, it doesn't
				 * matter) value
				 */
				/* Means no match */
				else if (cTable[i - 1][j] >= cTable[i][j - 1]) {
					cTable[i][j] = cTable[i - 1][j];
					bTable[i][j] = "N";
				}

				/* for example, left value < top value */
				else {
					cTable[i][j] = cTable[i][j - 1];
					bTable[i][j] = "W";
				}
			}
		}

		tablePair pair = new tablePair(bTable, cTable);
		return pair;
	}
	
	static void printLCS(String [][] bTable, String A, int i, int j) {
	 if(i==0||j==0) {
	 }	
	 /* NW represents go North West, AKA upper left*/
	 else if(bTable[i][j].equals("NW")) {
		 printLCS(bTable, A, i-1, j-1);
		 System.out.print(A.charAt(i-1));
	 }
	 /* N represents go North , AKA up*/
	 else if (bTable[i][j].equals("N")) {
		 printLCS(bTable, A, i-1, j);
	 }
	 else {
		 printLCS(bTable, A, i, j-1);
	 }
	 		
	}
	
}
