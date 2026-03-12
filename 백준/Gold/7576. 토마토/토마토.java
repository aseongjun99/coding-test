import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M, N;
    static int[][] box;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int unriped = 0;
    static Queue<int[]> q = new LinkedList<>();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) {
                    unriped++;
                }
                else if (box[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
    }

    static void ripe() {
        int day = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            day = now[2];

            for (int i=0;i<4;i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || box[ny][nx] != 0) {
                    continue;
                }

                q.add(new int[]{ny, nx, now[2]+1});
                unriped--;
                box[ny][nx] = 1;
            }
        }

        if (unriped == 0) {
            System.out.println(day);
        }
        else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        ripe();
    }
}