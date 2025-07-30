import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(score[0]);
        answer[0] = pq.peek();
        for (int i=1;i<score.length;i++) {
            pq.add(score[i]);
            if (pq.size() > k) {
                pq.poll();
            } 
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}