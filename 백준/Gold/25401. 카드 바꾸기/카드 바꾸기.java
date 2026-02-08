import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] nums;
    static Map<Integer, Boolean> visit = new HashMap<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void check() {
        int count = Integer.MAX_VALUE;
        for (int i=0;i<N-1;i++) {
            for (int j=i+1;j<N;j++) {
                int diff = (nums[j] - nums[i]) / (j-i);
                if (visit.get(diff) != null) {
                    continue;
                }
                visit.put(diff, true);
                int c = 0;
                int before = nums[0];
                for (int k=1;k<N;k++) {
                    if (nums[k] - before != diff) {
                        before += diff;
                        c++;
                    }
                    else {
                        before += diff;
                    }
                }
                count = Math.min(count, c);
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        input();
        check();
        
    }
}