import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, k;
    static int[][][] map;

    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean hasArrived(int y, int x) {
        return y == N-1 && x == M-1;
    }

    static boolean hasVisitedBelowBreakCount(int ny, int nx, int breakCount) {
        for (int i=0;i<=breakCount;i++) {
            if (map[ny][nx][i] == 1) {
                return true;
            }
        }
        return false;
    }

    static int changeDayNight(int dayNight) {
        return dayNight == 1 ? 2 : 1;
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M][K+2];
        // [i][j][n] == 벽을 n번 부수고 방문한 여부
        // [i][j][k] == (i, j)의 정보
        k = K+1;
        for (int i=0;i<N;i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0;j<M;j++) {
                map[i][j][k] = input[j] - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 1, 1}); // y, x, 누적 벽 부순 횟수, 누적 이동 횟수, 낮/밤(1/2)
        for (int i=0;i<k;i++) {
            map[0][0][i] = 1;
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if (hasArrived(now[0], now[1])) {
                System.out.println(now[3]);
                return;
            }

            for (int i=0;i<4;i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }

                // 경우의 수
                // 1. 목적지가 벽이 아니고, 현재 상태가 낮인 경우
                // 1-1. 현재 누적 벽 부순 횟수 이하의 방문 기록이 있으면 패스
                // 1-2. 1-1이 아니면 해당 좌표 방문
                // 2. 목적지가 벽이고, 현재 상태가 낮인 경우
                // 2-1. 현재 누적 벽 부순 횟수가 K이거나, 1-1과 동일하다면 패스
                // 2-2. 2-1이 아니면 해당 좌표 방문
                // 3. 목적지가 벽이 아니고, 현재 상태가 밤인 경우
                // 3-1. 1-1과 동일하다면 패스
                // 3-2. 3-1이 아니면 해당 좌표 방문
                // 4. 목적지가 벽이고, 현재 상태가 밤인 경우
                // 4-1. 현재 누적 벽 부순 횟수가 K면 패스
                // 4-2. 현재 누적 벽 부순 횟수 이하의 방문 기록이 있으면 패스
                // 4-3. 4-1,4-2가 아니라면 현재 좌표 유지하고 이동횟수 + 1

                if (map[ny][nx][k] == 0 && now[4] == 1) {
                    if (hasVisitedBelowBreakCount(ny, nx, now[2])) {
                        continue;
                    }
                    q.add(new int[] {ny, nx, now[2], now[3]+1, changeDayNight(now[4])});
                    map[ny][nx][now[2]] = 1;
                }
                else if (map[ny][nx][k] == 1 && now[4] == 1) {
                    if (now[2] == K) {
                        continue;
                    }
                    if (hasVisitedBelowBreakCount(ny, nx, now[2])) {
                        continue;
                    }
                    q.add(new int[] {ny, nx, now[2]+1, now[3]+1, changeDayNight(now[4])});
                    map[ny][nx][now[2]+1] = 1;
                }
                else if (map[ny][nx][k] == 0 && now[4] == 2) {
                    if (hasVisitedBelowBreakCount(ny, nx, now[2])) {
                        continue;
                    }
                    q.add(new int[] {ny, nx, now[2], now[3]+1, changeDayNight(now[4])});
                    map[ny][nx][now[2]] = 1;
                }
                else if (map[ny][nx][k] == 1 && now[4] == 2) {
                    if (now[2] == K) {
                        continue;
                    }
                    if (hasVisitedBelowBreakCount(ny, nx, now[2])) {
                        continue;
                    }
                    q.add(new int[] {now[0], now[1], now[2], now[3]+1, changeDayNight(now[4])});
                }
            }
        }
        System.out.println(-1);
    }
}