import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][][] map;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int k = K+1;
        // [i][j][n] = n번 벽 부순 후 방문
        // [i][j][k+1] = 좌표 정보
        map = new int[N][M][K+2];

        for (int i=0;i<N;i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0;j<M;j++) {
                map[i][j][k] = input[j] - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N-1 && now[1] == M-1) {
                System.out.println(now[3]);
                return;
            }

            for (int i=0;i<4;i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                // 현재와 동일한 벽 부순 횟수 이하에서의 방문 기록있으면 패스
                boolean flag = false;
                for (int j=now[2];j>=0;j--) {
                    if (map[ny][nx][j] == 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }

                if (map[ny][nx][k] == 1) {
                    if (now[2] == K) {
                        continue;
                    }
                    if (map[ny][nx][now[2]+1] == 1) {
                        continue;
                    }
                    q.add(new int[]{ny, nx, now[2]+1, now[3]+1});
                    map[ny][nx][now[2]+1] = 1;
                }
                else {
                    q.add(new int[]{ny, nx, now[2], now[3]+1});
                    map[ny][nx][now[2]] = 1;
                }
            }
        }

        System.out.println(-1);
    }
}