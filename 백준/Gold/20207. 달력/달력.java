import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] schedules = new int[367];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for (int j=S;j<=E;j++) {
                schedules[j]++;
            }
        }

        // 1부터 365까지 순회하며 일정이 끊어지는 순간까지 width++
        // height는 항상 max()를 통해 저장해두며
        // 일정이 끊어지는 순간 width * height 후 height과 width를 0으로 초기화
        int width = 0;
        int height = 0;
        int answer = 0;
        for (int i=1;i<367;i++) {
            if (schedules[i] == 0) {
                answer += width * height;
                width = 0;
                height = 0;
            }
            else {
                height = Math.max(height, schedules[i]);
                width++;
            }
        }
        
        System.out.println(answer);
    }
}