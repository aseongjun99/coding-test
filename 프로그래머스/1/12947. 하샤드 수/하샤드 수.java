class Solution {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;
        while (n > 0) {
            sum += n%10;
            n/=10;
        }

        boolean answer = true;
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}