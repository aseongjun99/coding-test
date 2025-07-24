
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pl = p.length();
        long pnum = Long.parseLong(p);
        
        for (int i=0;i+pl<=t.length();i++) {
            long sub = Long.parseLong(t.substring(i, i+pl));
            if (sub <= pnum) {
                answer++;
            }
        }
        return answer;
    }
}