import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        int idx = 0;
        while (left <= right) {
            int div = (int) (left / (long) n);
            int mod = (int) (left % (long) n);
            
            int num = div+1;
            if (mod <= div) {
                answer[idx] = num;
            }
            else {
                answer[idx] = num + (mod - div);
            }
         
            left++;
            idx++;
        }
        
        return answer;
    }
}