import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == 'o') {
                i += 2;
                sb.append(1);
            }
            else if (c == 'z') {
                i += 3;
                sb.append(0);
            }
            else if (c == 't') {
                char nc = s.charAt(i+1);
                if (nc == 'w') {
                    i += 2;
                    sb.append(2);
                }
                else if (nc == 'h') {
                    i += 4;
                    sb.append(3);
                }
            }
            else if (c == 'f') {
                char nc = s.charAt(i+1);
                if (nc == 'o') {
                    i += 3;
                    sb.append(4);
                }
                else if (nc == 'i') {
                    i += 3;
                    sb.append(5);
                }
            }
            else if (c == 's') {
                char nc = s.charAt(i+1);
                if (nc == 'i') {
                    i += 2;
                    sb.append(6);
                }
                else if (nc == 'e') {
                    i += 4;
                    sb.append(7);
                }
            }
            else if (c == 'e') {
                i += 4;
                sb.append(8);
            }
            else if (c == 'n') {
                i += 3;
                sb.append(9);
            }
            else {
                sb.append(c);
            }
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}