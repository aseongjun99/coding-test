import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	static int[] weights;
	static int[] values;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weights = new int[N+1];
		values = new int[N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[K+1][N+1];
		for (int i=1;i<K+1;i++) {
			for (int j=1;j<N+1;j++) {
				if (i - weights[j] >= 0) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-weights[j]][j-1] + values[j]);					
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
	

		System.out.println(dp[K][N]);
	}
}
