class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) {
            answer = false;
        }
        
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c-'0' < 0 || c-'0' > 9) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}