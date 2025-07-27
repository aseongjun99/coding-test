import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> s = new TreeSet<>();
        for (int i=0;i<numbers.length-1;i++) {
            for (int j=i+1;j<numbers.length;j++) {
                s.add(numbers[i] + numbers[j]);
            }
        }
                
        int[] answer = new int[s.size()];
        int idx = 0;
        for (int n : s) {
            answer[idx++] = n;
        }
        return answer;
    }
}