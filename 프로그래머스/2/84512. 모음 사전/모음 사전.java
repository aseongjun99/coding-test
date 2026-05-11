import java.util.*;
import java.io.*;

class Solution {
    
    static int res = 0;
    static List<String> list = new ArrayList<>();
    static boolean flag = false;
    
    static void makeWord(String word, String w, int depth) {
        if (word.equals(w)) {
            flag = true;
            return;
        }
        if (depth == 5) {
            return;
        }
        
        for (int i=0;i<list.size();i++) {
            if (!flag) {
                res++;
                makeWord(word, w+list.get(i), depth+1);
            }
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        list.add("A");
        list.add("E");
        list.add("I");
        list.add("O");
        list.add("U");
        
        makeWord(word, "", 0);
        
        answer = res;
        
        return answer;
    }
}