
/* 
 * Student name: Edward Lin
 * Student ID: #1942366
 * assignment name: MED.java
 * */

public class MED {
	public static void main(String args[]) {
		String s1 = "Depaul";
		String s2 = "Declaw";
		System.out.println("The minimun edit distance between "+s1+" and "+s2+" is " + MED(s1, s2, s1.length(), s2.length()));
	}

	public static int MED(String s1, String s2, int s1Length, int s2Length) {
		/* Base on slide DP2 updated p.16 */
		/* base case: if i=0 or j=0 -> max(i, j) */
		if (s1Length==0||s2Length==0) {
			return Math.max(s1Length, s2Length);
		}

		/* if xi = yj => return D[i-1,j-1] */
		else if (s1.charAt(s1Length-1) == s2.charAt(s2Length-1)) {
			return MED(s1, s2, s1Length - 1, s2Length - 1);
		}

		/* if xi != yj => return 1+ min(D[i-1,j], D[i,j-1], D[i-1, j-1]) */
			return 1 + Math.min(
					Math.min(MED(s1, s2, s1Length - 1, s2Length), MED(s1, s2, s1Length, s2Length - 1)),
					MED(s1, s2, s1Length - 1, s2Length - 1));

		
	}
}
