import java.util.*;
import java.io.*;

class Solution {
    
    static String[] str;
    
    public String solution(int[] numbers) {
        str = new String[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, (a, b) -> {
            if ((a+b).compareTo(b+a) > 0) {
                return -1;
            }
            else if ((a+b).compareTo(b+a) < 0) {
                return 1;
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length;i++) {
            sb.append(str[i]);
        }
        
        String answer = sb.toString();
        
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}