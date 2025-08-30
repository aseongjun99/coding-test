import java.util.*;
import java.io.*;

public class Main {

    static int M, N, H;
    static int[][][] box;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        int ripe = 0;
        int unripe = 0;
        int empty = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<H;i++) {
            for (int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0;k<M;k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        ripe++;
                        // h, n, m, 일
                        q.add(new int[] {i, j, k, 1});
                    }
                    else if(box[i][j][k] == 0) {
                        unripe++;
                    }
                    else if (box[i][j][k] == -1) {
                        empty++;
                    }
                }
            }
        }

        // 저장될 때부터 모든 토마토 익음
        if (unripe == 0) {
            System.out.println(0);
        }
        else {
            int day = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int z = now[0]; int y = now[1]; int x = now[2]; int d = now[3];

                for (int i=0;i<6;i++) {
                    int nz = z + dz[i]; int ny = y + dy[i]; int nx = x + dx[i];
                    if (nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
                        continue;
                    }
                    if (box[nz][ny][nx] == -1 || box[nz][ny][nx] == 1) {
                        continue;
                    }
                    box[nz][ny][nx] = 1;
                    ripe++;
                    unripe--;
                    day = d;
                    q.add(new int[] {nz, ny, nx, d+1});
                }
            }

            if (unripe != 0) {
                System.out.println(-1);
            }
            else {
                System.out.println(day);
            }

        }

    }
}