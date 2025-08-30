import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] box;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        
        Queue<int[]> q = new LinkedList<>();
        int ripe = 0;
        int empty = 0;

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    q.add(new int[] {i, j, 1});
                    ripe++;
                }
                else if (box[i][j] == -1) {
                    empty++;
                }
            }
        }

        // 저장될 때 부터 다 익으면 0
        if (ripe == N*M) {
            System.out.println(0);
        }
        else {
            int day = 0;
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int y = now[0]; int x = now[1];
                int nextDay = now[2];

                for (int i=0;i<4;i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (box[ny][nx] == -1 || box[ny][nx] == 1) {
                        continue;
                    }

                    box[ny][nx] = 1;
                    ripe++;
                    day = nextDay;

                    q.add(new int[] {ny, nx, nextDay+1});
                }
            }

            if (ripe != N*M - empty) {
                System.out.println(-1);
            }
            else {
                System.out.println(day);
            }
        }



    }
}