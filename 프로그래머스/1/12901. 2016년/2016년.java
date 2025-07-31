class Solution {
    public String solution(int a, int b) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i=1;i<a;i++) {
            sum += days[i];
        }
        sum += b;
        
        String answer = "";
        String[] arr = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        answer = arr[sum % 7];
        
        return answer;
    }
}