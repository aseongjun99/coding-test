import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] nums;
    static int[] operators;
    static boolean[] visit;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N-1];
        
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[N-1];
        int idx = 0;
        for (int i=0;i<4;i++) {
            int o = Integer.parseInt(st.nextToken());
            for (int j=0;j<o;j++) {
                operators[idx++] = i;
            }
        }
    }
    
    static void permutation(int depth, List<Integer> p) {
        if (depth == operators.length) {
            calculate(p);
            return;
        }

        for (int i=0;i<operators.length;i++) {
            if (!visit[i]) {
                visit[i] = true;
                p.add(operators[i]);
                permutation(depth+1, p);
                p.remove(p.size()-1);
                visit[i] = false;
            }
        }
    }

    static void calculate(List<Integer> p) {
        int numIdx = 0;
        int res = nums[numIdx++];

        for (int i=0;i<p.size();i++) {
            int o = p.get(i);
            if (o == 0) {
                res = plus(res, nums[numIdx++]);
            }
            else if (o == 1) {
                res = minus(res, nums[numIdx++]);
            }
            else if (o == 2) {
                res = mul(res, nums[numIdx++]);
            }
            else if (o == 3) {
                res = div(res, nums[numIdx++]);
            }
        }
        minNum = Math.min(minNum, res);
        maxNum = Math.max(maxNum, res);
    }

    static int plus(int r, int n) {
        return r+n;
    }

    static int minus(int r, int n) {
        return r-n;
    }

    static int mul(int r, int n) {
        return r*n;
    }

    static int div(int r, int n) {
        if (r < 0) {
            r *= -1;
            return r/n*(-1);
        }
        return r/n;
    }

    public static void main(String[] args) throws Exception {
        input();
        permutation(0, new ArrayList<>());
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}