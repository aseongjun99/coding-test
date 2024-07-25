import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
//	static boolean checkACGT(String subString, int[] minCount) {
//		int[] acgtCount = new int[4];
//		for (int i=0;i<subString.length();i++) {
//			if (subString.charAt(i) == 'A') {
//				acgtCount[0]++;
//			}
//			if (subString.charAt(i) == 'C') {
//				acgtCount[1]++;
//			}
//			if (subString.charAt(i) == 'G') {
//				acgtCount[2]++;
//			}
//			if (subString.charAt(i) == 'T') {
//				acgtCount[3]++;
//			}	
//		}
//		
//		for (int i=0;i<4;i++) {
//			if (acgtCount[i] < minCount[i]) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	static boolean passwordAvailable(int[] acgtCount, int[] minCount) {
		for (int i=0;i<4;i++) {
			if (acgtCount[i] < minCount[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		String dna = br.readLine();
		
		int[] minCount = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<4;i++) {
			minCount[i] = Integer.parseInt(st.nextToken());
		}
		int[] acgtCount = new int[4];
		
		int answer = 0;
		String subString = dna.substring(0, T);
		for (int i=0;i<subString.length();i++) {
			if (subString.charAt(i) == 'A') {
				acgtCount[0]++;
			} else if (subString.charAt(i) == 'C') {
				acgtCount[1]++;
			} else if (subString.charAt(i) == 'G') {
				acgtCount[2]++;
			} else if (subString.charAt(i) == 'T') {
				acgtCount[3]++;
			}
		}
		
		if (passwordAvailable(acgtCount, minCount)) {
			answer++;
		}
		
		for (int i=1;i<S-T+1;i++) {
			if (dna.charAt(i-1) == 'A') {
				acgtCount[0]--;
			} else if (dna.charAt(i-1) == 'C') {
				acgtCount[1]--;
			} else if (dna.charAt(i-1) == 'G') {
				acgtCount[2]--;
			} else if (dna.charAt(i-1) == 'T') {
				acgtCount[3]--;
			}
			
			if (dna.charAt(i+T-1) == 'A') {
				acgtCount[0]++;
			} else if (dna.charAt(i+T-1) == 'C') {
				acgtCount[1]++;
			} else if (dna.charAt(i+T-1) == 'G') {
				acgtCount[2]++;
			} else if (dna.charAt(i+T-1) == 'T') {
				acgtCount[3]++;
			}
			
			if (passwordAvailable(acgtCount, minCount)) {
				answer++;
			}
		}
//		for (int i=0;i<S-T+1;i++) {
//			String subString = dna.substring(i, i+T);
//			if (checkACGT(subString, minCount)) {
//				answer++;
//			}
//		}
		System.out.println(answer);
		
	}
}
