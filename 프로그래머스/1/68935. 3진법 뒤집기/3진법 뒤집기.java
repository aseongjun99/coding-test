import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 3);
            n /= 3;
        }
        
        int pow = 0;
        int answer = 0;
        for (int i=list.size()-1;i>=0;i--) {
             answer += list.get(i) * Math.pow(3, pow++);
        }
        return answer;
    }
}