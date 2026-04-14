import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, r, c, d;
    static int[][] map;
    static int answer = 0;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1 ,1};
    static int nr, nc;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean isAllWallAround() {
        for (int i=0;i<4;i++ ){
            nr = r + dy[i];
            nc = c + dx[i];
            if (map[nr][nc] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean canMoveBackward() {
        if (d == 0) {
            nr = r+1;
            nc = c;
        }
        else if (d == 1) {
            nr = r;
            nc = c-1;
        }
        else if (d == 2) {
            nr = r-1;
            nc = c;
        }
        else {
            nr = r;
            nc = c+1;
        }

        if (map[nr][nc] == 1) {
            return false;
        }
        return true;
    }

    static void moveBackward() {
        r = nr;
        c = nc;
    }

    static void clean() {
        while (true) {
            // print();
            if (map[r][c] == 0) {
                answer++;
                map[r][c] = 2;
            }
    
            if (isAllWallAround()) {
                if (canMoveBackward()) {
                    moveBackward();
                }
                else {
                    return;
                }
            }
            else {
                rotate();
                if (isForwardUncleaned()) {
                    moveForward();
                }
            }
        }
    }

    static void moveForward() {
        r = nr;
        c = nc;
    }

    static boolean isForwardUncleaned() {
        if (d == 0) {
            nr = r-1;
            nc = c;
        }
        else if (d == 1) {
            nr = r;
            nc = c+1;
        }
        else if (d == 2) {
            nr = r+1;
            nc = c;
        }
        else {
            nr = r;
            nc = c-1;
        }
        
        if (map[nr][nc] == 0) {
            return true;
        }
        return false;
    }
    
    static void rotate() {
        d--;
        if (d == -1) {
            d = 3;
        }
    }

    static void print() {
        System.out.println();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        clean();
        System.out.println(answer);
    }
}