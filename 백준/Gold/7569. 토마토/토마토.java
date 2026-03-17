import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int M, N, H;
    static int[][][] box;
    static int unripedCount = 0;
    static Queue<int[]> pos = new LinkedList();

    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        for (int h=0;h<H;h++ ){
            for (int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<M;j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                    if (box[h][i][j] == 0) {
                        unripedCount++;
                    }
                    else if (box[h][i][j] == 1) {
                        pos.add(new int[]{h, i, j, 0});
                    }
                }
            }
        }
    }

    static void ripe() {
        int day = 0;
        while (!pos.isEmpty()) {
            int[] now = pos.poll();

            for (int i=0;i<6;i++) {
                int nh = now[0] +dh[i];
                int ny = now[1] +dy[i];
                int nx = now[2] + dx[i];

                if (nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }
                else if (box[nh][ny][nx] == -1 || box[nh][ny][nx] == 1) {
                    continue;
                }
                
                box[nh][ny][nx] = 1;
                unripedCount--;
                if (unripedCount == 0) {
                    day = now[3]+1;
                    break;
                }
                pos.add(new int[]{nh, ny, nx, now[3]+1});
            }
            // System.out.println("now : " + now[3]);
            // print();
        }

        if (unripedCount != 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(day);
        }
    }

    static void print() {
        for (int h=0;h<H;h++) {
            for (int n=0;n<N;n++) {
                for (int m=0;m<M;m++) {
                    System.out.print(box[h][n][m] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        ripe();
    }
}