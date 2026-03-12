import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] pic;
    static int maxWidth = 0;
    static int nums = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int flag = 2;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pic = new int[n][m];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void findPics(int y, int x) {
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i=0;i<4;i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || pic[ny][nx] != 1) {
                    continue;
                }

                q.add(new int[]{ny, nx});
                pic[ny][nx] = flag;
                count++;
            }
        }

        maxWidth = Math.max(maxWidth, count);
    }


    public static void main(String[] args) throws Exception {
        input();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (pic[i][j] == 1) {
                    nums++;
                    pic[i][j] = flag;
                    findPics(i, j);
                    flag++;
                }
            }
        }

        System.out.println(nums);
        System.out.println(maxWidth);
    }
}