import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int answer = Integer.MAX_VALUE;

    static int[][][] maze = new int[5][5][5];
    static int[][][] copy = new int[5][5][5];

    // 위, 아래, 상, 하, 좌, 우
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    static List<Integer> p = new ArrayList<>();
    static List<List<Integer>> perm = new ArrayList<>();
    static boolean[] visit = new boolean[5];
    
    static void input() throws IOException {
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0;k<5;k++) {
                    maze[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void permutation() {
        if (p.size() == 5) {
            perm.add(new ArrayList<>(p));
            return;
        }

        for (int i=0;i<5;i++) {
            if (!visit[i]) {
                p.add(i);
                visit[i] = true;
                permutation();
                p.remove(p.size()-1);
                visit[i] = false;
            }
        }
    }

    static void rotateDfs(int idx) {
        // 종료
        if (idx == 5) {
            bfs();
            return;
        }

        // 다음 뎁스
        rotateDfs(idx+1);

        // 현재 판 회전하고 탐색 (총 3번 회전 가능)
        for (int i=0;i<3;i++) {
            rotate(idx);
            rotateDfs(idx+1);
        }
    }

    static void rotate(int target) {
        int[][] c = new int[5][5];
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                c[i][j] = copy[target][i][j];
            }
        }

        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                copy[target][i][j] = c[5-1-j][i];
            }
        }
    }

    static void bfs() {
        if (copy[0][0][0] == 0) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[5][5][5];
        q.add(new int[]{0,0,0,0}); // z, y, x, 이동횟수
        v[0][0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == 4 && now[1] == 4 && now[2] == 4) {
                answer = Math.min(answer, now[3]);
                return;
            }

            for (int i=0;i<6;i++) {
                int nz = now[0] + dz[i];
                int ny = now[1] + dy[i];
                int nx = now[2] + dx[i];

                if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5 || v[nz][ny][nx] || copy[nz][ny][nx] == 0) {
                    continue;

                }

                q.add(new int[]{nz, ny, nx, now[3]+1});
                v[nz][ny][nx] = true;
            }
        }
    }

    static void stack() {
        for (int i=0;i<perm.size();i++) {
            List<Integer> now = perm.get(i);
            copy(now);
            rotateDfs(0);
        }
    }

    static void copy(List<Integer> now) {
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                for (int k=0;k<5;k++) {
                    copy[i][j][k] = maze[now.get(i)][j][k];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        permutation();
        stack();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
}