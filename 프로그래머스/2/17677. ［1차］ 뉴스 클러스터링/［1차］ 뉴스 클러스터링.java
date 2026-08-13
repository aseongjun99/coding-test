import java.util.*;
import java.io.*;

class Solution {
    
    static double inter = 0;
    static double union = 0;
    static StringBuilder sb1;
    static StringBuilder sb2;
    
    static boolean isCapital(char c) {
        return 'A' <= c && c <= 'Z';
    }
    
    static boolean isAlphabet(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }
    
    static String smallLetter(char c) {
        return Character.toString(c).toLowerCase();
    }
    
    public double solution(String str1, String str2) {
        // 1. 대문자로 변환
        // 2. 1번 문자열 두글자씩 순회 -> 2번 문자열 두글자씩 순회
        // 3. 두 문자열 같으면 inter++, union++, 1번 문자열 시작인덱스 '-' 로 치환, 2번 문자열 시작인덱스 소문자로 치환
        // 4. 1번 문자열 순회 시, 대문자 알파벳 아니면 패스
        // 5. 3번에서 두 문자열 다르면 2번문자열 순회 -> 끝까지 다르면 union++, 1번 문자열 시작 인덱스 '-'로 치환
        // 6. 두 문자열 비교 시, 2번 문자열의 시작 인덱스가 대문자 알파벳 아니면 패스 + 끝 인덱스가 알파벳이 아니면 패스
        double answer = 65536;
        
        sb1 = new StringBuilder(str1.toUpperCase());
        sb2 = new StringBuilder(str2.toUpperCase());
        
        for (int i=0;i<sb1.length()-1;i++) {
            if (!isCapital(sb1.charAt(i)) || !isCapital(sb1.charAt(i+1))) {
                continue;
            }
            String now1 = sb1.substring(i, i+2);
            boolean isEqual = false;
            
            for (int j=0;j<sb2.length()-1;j++) {
                if (!isCapital(sb2.charAt(j))) {
                    continue;
                }
                if (!isAlphabet(sb2.charAt(j+1))) {
                    continue;
                }
                String now2 = sb2.substring(j, j+2).toUpperCase();
                
                if (now1.equals(now2)) {
                    inter++; union++;
                    sb1.replace(i, i+1, "-");
                    sb2.replace(j, j+1, smallLetter(sb2.charAt(j)));
                    isEqual = true;
                    break;
                }
            }
            
            if (!isEqual) {
                union++;
                sb1.replace(i, i+1, "-");
            }
        }
        for (int i=0;i<sb2.length()-1;i++) {
            if (isCapital(sb2.charAt(i)) && isAlphabet(sb2.charAt(i+1))) {
                union++;
            }
        }
        
        if (union != 0) {
            answer = Math.floor((inter/union) * 65536);
        }
        
        return answer;
    }
}