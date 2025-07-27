class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(' ');
            }
            else if ('a' <= c && c <= 'z') {
                char newc = (char) (c + n);
                if (newc > 'z') {
                    newc = (char) ('a' + (newc - 'z') - 1);
                }
                sb.append(newc);
            }
            else {
                char newc = (char) (c + n);
                if (newc > 'Z') {
                    newc = (char) ('A' + (newc - 'Z') - 1);
                }
                sb.append(newc);
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}