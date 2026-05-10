import java.util.*;
import java.io.*;

class Solution {
    
    static String[] nums;
    static boolean[] visit;
    static int count = 0;
    static Map<Integer, Boolean> map = new HashMap<>();
    
    static void makeNumbers(String n, int len) {
        if (len == nums.length) {
            isPrime(n);
            return;
        }
        
        // 현재 숫자 선택
        for (int i=0;i<nums.length;i++) {
            if (!visit[i]) {
                visit[i] = true;
                makeNumbers(n+nums[i], len+1);
        // 현재 숫자 선택 x
                makeNumbers(n, len+1);
                visit[i] = false;
            }
        }
    }
    
    static void isPrime(String n) {
        int num = Integer.parseInt(n);
        if (map.get(num) != null) {
            return;
        }
        map.put(num, true);
        if (num < 2) {
            return;
        }
        for (int i=2;num >= i*i;i++) {
            if (num % i == 0) {
                return;
            }
        }
        count++;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        nums = numbers.split("");
        for (int i=0;i<nums.length;i++) {
            visit[i] = true;
            makeNumbers(nums[i], 1);
            visit[i] = false;
        }
        answer = count;
        return answer;
    }
}