import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer> list = new ArrayList<>();
    static long[] arr;
    public int[] solution(int n, long k) {
        arr = new long[n+1];
        arr[1] = 1;
        list.add(1);
        for (int i=2;i<=n;i++) {
            arr[i] = arr[i-1] * (i-1);
            list.add(i);
        }
        k--;
        int[] answer = new int[n];
        int idx = 0;
                               
        while (!list.isEmpty()) {
            int div = (int) (k/arr[n]);
            answer[idx++] = list.get(div);
            list.remove(div);
            k %= arr[n--];
        }
        
        return answer;
    }
}