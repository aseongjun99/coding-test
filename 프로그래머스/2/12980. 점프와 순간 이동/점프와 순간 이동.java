import java.util.*;

public class Solution {
    
    static int[] dp;
    
    public int solution(int n) {
        int ans = 0;
        
        while (n>0) {
            if (n%2 == 0) {
                n/=2;
            }
            else {
                n -= 1;
                ans++;
            }
        }
        
        
//         dp = new int[n+1];
//         dp[0] = 0;
//         for (int i=1;i<n+1;i++) {
//             if (i % 2 == 0) {
//                 dp[i] = dp[i/2];
//             }
//             else {
//                 dp[i] = dp[i-1]+1;
//             }
//         }
//         ans = dp[n];
        return ans;
    }
}