import java.util.*;
import java.io.*;

class Solution {
    
    static Queue<Character> q = new LinkedList<>();
    static Map<Character, Boolean> visit = new HashMap<>();
    
    static boolean check(String st) {
        for (int i=0;i<st.length();i++) {
            char c = st.charAt(i);
            
            if (visit.get(c) == null) {
                continue;
            }
            
            if (q.peek() != c) {
                return false;
            }
            q.poll();
            if (q.isEmpty()) {
                return true;
            }
        }
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        for (int i=0;i<skill.length();i++) {
            char c = skill.charAt(i);
            visit.put(c, true);
            q.add(c);
        }
        int answer = 0;
        
        for (int i=0;i<skill_trees.length;i++) {
            if (check(skill_trees[i])) {
                answer++;
            }
            q.clear();
            for (int j=0;j<skill.length();j++) {
                q.add(skill.charAt(j));
            }
        }        
        return answer;
    }
}