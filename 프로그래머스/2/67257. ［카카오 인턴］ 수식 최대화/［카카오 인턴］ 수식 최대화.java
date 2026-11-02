import java.util.*;
import java.io.*;

class Solution {

    static char[][] operations = {
        {'*', '+', '-'},
        {'*', '-', '+'},
        {'-', '*', '+'},
        {'-', '+', '*'},
        {'+', '-', '*'},
        {'+', '*', '-'},
    };
    
    static List<Long> nums = new ArrayList<>();
    static List<Character> opers = new ArrayList<>();
    
    static boolean isOperation(char c) {
        return (c == '*' || c == '-' || c == '+');
    }
    
    static long getPreviousNum(StringBuilder sb, int idx) {
        String str = sb.substring(0, idx);
        sb.replace(0, idx+1, "");
        return Long.parseLong(str);
    }
    
    static void split(StringBuilder sb) {
        int i=0;
        while (i<sb.length()) {
            if (isOperation(sb.charAt(i))) {
                opers.add(sb.charAt(i));    
                nums.add(getPreviousNum(sb, i));
                i=0;
            }
            else {
                i++;
            }
        }
        nums.add(Long.parseLong(sb.toString()));
    }
    
    static long calc(int idx, List<Long> cpNums, List<Character> cpOpers) {
        long num1 = cpNums.get(idx);
        long num2 = cpNums.get(idx+1);
        if (cpOpers.get(idx) == '*') {
            return num1*num2;
        }
        else if (cpOpers.get(idx) == '-') {
            return num1-num2;
        }
        else {
            return num1+num2;
        }
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        StringBuilder sb = new StringBuilder(expression);
        split(sb);
        
        for (int i=0;i<6;i++) {
            List<Long> cpNums = new ArrayList<>(nums);
            List<Character> cpOpers = new ArrayList<>(opers);
            for (int j=0;j<3;j++) {
                char o = operations[i][j];
                int k = 0;
                while (k < cpOpers.size()) {
                    if (cpOpers.get(k) == o) {
                        long res = calc(k, cpNums, cpOpers);
                        cpNums.remove(k+1);
                        cpNums.remove(k);
                        cpOpers.remove(k);
                        cpNums.add(k, res);
                    }
                    else {
                        k++;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cpNums.get(0)));
        }
        
        return answer;
    }
}