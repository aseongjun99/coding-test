import java.util.*;
import java.io.*;

class Solution {
    
    static int startIdx = 0;
    static int sum = 0;
    
    static void sameAsK(int[] ans, int[] seq, int nowIdx) {
        int ansDiff = ans[1] - ans[0];
        int nowDiff = nowIdx - startIdx;
        
        if (nowDiff < ansDiff) {
            renewAnswer(ans, nowIdx);
        }
        
        sum -= seq[startIdx++];
    }
    
    static void biggerThanK(int[] ans, int[] seq, int nowIdx, int k) {
        while (sum > k) {
            sum -= seq[startIdx++];
        }
        
        if (sum == k) {
            sameAsK(ans, seq, nowIdx);
        }
    }
    
    static void renewAnswer(int[] ans, int nowIdx) {
        ans[0] = startIdx;
        ans[1] = nowIdx;
    }
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{1000001, 9999999};
        
        for (int i=0;i<sequence.length;i++) {
            sum += sequence[i];
            
            if (sum == k) {
                sameAsK(answer, sequence, i);
            }
            else if (sum > k) {
                biggerThanK(answer, sequence, i, k);
            }
        }
        
        return answer;
    }
}