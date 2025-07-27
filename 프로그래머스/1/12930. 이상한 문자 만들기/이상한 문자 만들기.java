import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                idx = 0;
                sb.append(' ');
            }
            else {
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
                idx++;
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}