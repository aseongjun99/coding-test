import java.util.*;
import java.io.*;

class Solution {
    
    static int convertToNum(String str) {
        String[] arr = str.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        
        return h * 60 + m;
    }
    
    static int diff(String s, String e) {
        int S = convertToNum(s);
        int E = convertToNum(e);
        
        return E-S;
    }
    
    static String play(String sheet, int time) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i=0;i<time;i++) {
            sb.append(sheet.charAt(idx++));
            if (idx == sheet.length()) {
                idx = 0;
            }
        }
        return sb.toString();
    }
    
    static String convertSharp(String str) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < str.length()) {
            if (str.charAt(idx) == '#') {
                char scale = str.charAt(idx-1);
                scale -= ('A' - 'a');
                sb.deleteCharAt(sb.length()-1);
                sb.append(scale);
            }
            else {
                sb.append(str.charAt(idx));
            }
            idx++;
        }
        return sb.toString();
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = convertSharp(m);
        
        int max = 0;
        for (int i=0;i<musicinfos.length;i++) {
            String[] info = musicinfos[i].split(",");
            String startTime = info[0];
            String endTime = info[1];
            String name = info[2];
            String sheet = convertSharp(info[3]);
            
            int time = diff(startTime, endTime);
            String played = play(sheet, time);
            System.out.println(played);
            if (played.contains(m) && max < played.length()) {
                max = played.length();
                answer = name;
            }
        }
        
        if (answer.equals("")) {
            answer = "(None)";
        }
        
        return answer;
    }
}