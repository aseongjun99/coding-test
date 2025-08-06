class Solution {
    public int solution(String s) {
        int idx = 0;
        int xc = 0; int notxc = 0;
        char x = ' ';
        int answer = 0;
        while (idx < s.length()) {
            if (xc != 0 && notxc != 0 && xc == notxc) {
                answer++;
                xc = 0; notxc = 0;
            }
            else if (xc == 0) {
                x = s.charAt(idx++);
                xc++;
            }
            else {
                char now = s.charAt(idx++);
                if (x == now) {
                    xc++;
                }
                else if (x != now) {
                    notxc++;
                }
            }
        }
        answer++;
        
        return answer;
    }
}