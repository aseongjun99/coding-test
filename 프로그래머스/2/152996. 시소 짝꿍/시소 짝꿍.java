import java.util.*;
import java.io.*;

class Solution {
    
    static Map<Integer, Long> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>(); // visit
    
    public long solution(int[] weights) {
        long answer = 0;
        
        for (int i=0;i<weights.length;i++) {
            if (map.get(weights[i]) == null) {
                map.put(weights[i], 1l);
            }
            else {
                map.put(weights[i], map.get(weights[i])+1l);
            }
        }
        
        Arrays.sort(weights);
        
        for (int i=0;i<weights.length;i++) {
            int w = weights[i];
            long now = map.get(w);
            
            if (set.contains(w)) {
                continue;
            }
            set.add(w);
            
            // 현재 몸무게 개수가 2 이상이면 개수만큼의 숫자가 만들 수 있는 경우의 수 합산
            if (now >= 2) {
                answer += (now * (now-1l)) / 2l;
            }
            // 현재 몸무게와 짝꿍인 숫자를 map에서 찾아내려면?
            // 몸무게 원본만 가지고 현재 숫자와 짝꿍인지 알 수 있나?
            // 현재 숫자 : x = 2:3, 2:4, 3:4 -> 현재 숫자의 3/2, 4/2, 4/3 인 숫자를 map에 접근
            // 정수일때만 해야함
            if (w * 3 % 2 == 0) {
                int num32 = w*3/2;
                // 만들어낸 숫자가 map에 있으면 현재 몸무게 개수와 조회된 개수를 가지고 만들어낼 수 있는 경우의 수 합치기
                if (map.get(num32) != null) {
                    answer += now * map.get(num32);
                }
            }
            if (w * 4 % 2 == 0) {
                int num42 = w*4/2;
                if (map.get(num42) != null) {
                    answer += now * map.get(num42);
                }
            }
            if (w * 4 % 3 == 0) {
                int num43 = w*4/3;
                if (map.get(num43) != null) {
                    answer += now * map.get(num43);
                }
            }
        }
        
        return answer;
    }
}