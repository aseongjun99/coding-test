import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // t초 동안 1초마다 x 만큼 회복
        // t초 연속 감기 성공 -> y 추가 회복
        // 최대 체력 초과 불가
        // 피격 시 취소
        // 피격 도중 체력 회복 불가
        // 취소 또는 종료 시 즉시 다시 사용 -> 연속 성공 시간 0으로 초기화
        // 체력 0 이하 되면 체력 회복 불가
        int maxHealth = health;
        for (int i=0;i<attacks.length-1;i++) {
            health -= attacks[i][1];
            if (health <= 0) {
                return -1;
            }
            int term = attacks[i+1][0] - attacks[i][0] - 1;
            int heal = (term / bandage[0] * bandage[2]) + ((term / bandage[0]) * bandage[0] * bandage[1]) + (term % bandage[0] * bandage[1]);
            health = Math.min(maxHealth, health+heal);
        }
        
        health -= attacks[attacks.length-1][1];
        if (health <= 0) {
            return -1;
        }
        return health;

    }
}