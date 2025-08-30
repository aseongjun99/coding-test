import java.util.*;
import java.io.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            return;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];
        q.add(new int[]{N, 0});
        visit[N] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == K) {
                System.out.println(now[1]);
                return;
            }

            int left = now[0] - 1;
            int right = now[0] + 1;
            int teleport = now[0] * 2;

            if (teleport <= 100000 && !visit[teleport]) {
                q.add(new int[]{teleport, now[1]});
                visit[teleport] = true;
            }

            if (left >= 0 && !visit[left]) {
                q.add(new int[]{left, now[1]+1});
                visit[left] = true;
            }

            if (right <= 100000 && !visit[right]) {
                q.add(new int[]{right, now[1]+1});
                visit[right] = true;
            }
        }
    }
}