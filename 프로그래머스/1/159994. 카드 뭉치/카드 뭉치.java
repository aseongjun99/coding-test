class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int ci1 = 0;
        int ci2 = 0;
        for (int i=0;i<goal.length;i++) {
            String g = goal[i];
            String c1 = "";
            String c2 = "";
            
            if (ci1 < cards1.length) {
                c1 = cards1[ci1];
            }
            if (ci2 < cards2.length) {
                c2 = cards2[ci2];
            }
            
            if (g.equals(c1)) {
                ci1++;
            }
            else if (g.equals(c2)) {
                ci2++;
            }
            else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}