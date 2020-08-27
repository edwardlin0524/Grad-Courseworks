
/* Exercise 15.4-1
 * Determine an LCS of (1,0,0,1,0,1,0,1) and (0,1,0,1,1,0,1,1,0).
 * 
 * My answer: 
 * (1,0,1,0,1,0) and the length is 6. By running following program and draw out the sign table to find what words are they.
 * */

public class LCS {

	public static void main(String[] args) {
		String A = "ABCBDAB";
		String B = "BDCABA";
//		String A = "10010101";
//		String B = "010110110";
		int result = FindLCS(A, B);
		System.out.println("The length of longest common subsequence between "+A+" & "+B+ " is: " + result);
	}

	static int FindLCS(String A, String B) {
		/*String length*/
		int Alength = A.length();
		int Blength = B.length();

		/* +1 means the position for storing \0 */
		int[][] LCSTable = new int[Alength+1][Blength+1];
		/* following codes would be easy to understand if reading it with table */
		for (int i = 0; i <= Alength; i++) {
			for (int j = 0; j <= Blength; j++) {
				if (i == 0 || j == 0) {
					/* Make first row 0 */
					LCSTable[i][j] = 0;
				}
				/*
				 * If these two numbers are same, put the number in upper left plus 1 into
				 * current index
				 */
				else if (A.charAt(i-1) == B.charAt(j-1)) {
					LCSTable[i][j] = LCSTable[i - 1][j - 1] + 1;
				}
				/* if Left value >= Top value, current value equals to left value */
				/* Means no match */
				else if (LCSTable[i - 1][j] >= LCSTable[i][j - 1]) {
					LCSTable[i][j] = LCSTable[i - 1][j];
				}
				/* for example, left value < top value */
				else {
					LCSTable[i][j] = LCSTable[i][j - 1];
				}
			}

		}
		return LCSTable[Alength][Blength];
	}
}
