import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int PR, PC;
    static char[][] map;
    static int count = 0;
    static int dir;
    static boolean infinite = false;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for (int i=0;i<N;i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        PR = Integer.parseInt(st.nextToken());
        PC = Integer.parseInt(st.nextToken());
    }

    static int changeDirection(char planet, int d) {
        if (planet == '/') {
            if (d == 0) {
                return 1;
            }
            else if (d == 1) {
                return 0;
            }
            else if (d == 2) {
                return 3;
            }
            else {
                return 2;
            }
        }
        else {
            if (d == 0) {
                return 3;
            }
            else if (d == 1) {
                return 2;
            }
            else if (d == 2) {
                return 1;
            }
        }
        return 0;
    }

    static void move(int d) {
        int startD = d;
        boolean[][][] visit = new boolean[N][M][4];
        int y = PR-1;
        int x = PC-1;
        visit[y][x][d] = true;

        int c = 1;
        while (true) {
            y += dy[d];
            x += dx[d];

            if (y < 0 || y >= N || x < 0 || x >= M) {
                break;
            }
            if (map[y][x] == 'C') {
                break;
            }
            if (visit[y][x][d]) {
                dir = startD;
                infinite = true;
                return;
            }

            visit[y][x][d] = true;
            if (map[y][x] == '/' || map[y][x] == '\\') {
                d = changeDirection(map[y][x], d);
                c++;
            }
            else {
                c++;
            }
        }

        if (count < c) {
            count = c;
            dir = startD;
        }
    }

    static void printDir() {
        if (dir == 0) {
            System.out.println("U");
        }
        else if (dir == 1) {
            System.out.println("R");
        }
        else if (dir == 2) {
            System.out.println("D");
        }
        else {
            System.out.println("L");
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        for (int i=0;i<4;i++) {
            if (!infinite) {
                move(i);
            }
        }

        if (infinite) {
            printDir();
            System.out.println("Voyager");
        }
        else {
            printDir();
            System.out.println(count);
        }
    }
}