import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visit[N] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == K) {
                System.out.println(now[1]);
                return;
            }

            int nx1 = now[0] + 1;
            if (nx1 >= 0 && nx1 <= 100000 && !visit[nx1]) {
                q.add(new int[]{nx1, now[1]+1});
                visit[nx1] = true;
            }

            int nx2 = now[0] - 1;
            if (nx2 >= 0 && nx2 <= 100000 && !visit[nx2]) {
                q.add(new int[]{nx2, now[1]+1});
                visit[nx2] = true;
            }

            int nx3 = now[0] * 2;
            if (nx3 >= 0 && nx3 <= 100000 && !visit[nx3]) {
                q.add(new int[]{nx3, now[1]+1});
                visit[nx3] = true;
            }
        }
    }
}