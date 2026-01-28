import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int answer = 0;
    static List<Integer>[] arr;
    static PriorityQueue<Integer> q = new PriorityQueue<>();

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for (int i=0;i<N+1;i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cups = Integer.parseInt(st.nextToken());
            arr[deadline].add(cups);
        }
    }

    static void sortByCups() {
        for (int i=0;i<N+1;i++) {
            arr[i].sort(Collections.reverseOrder());
        }
    }

    static void print() {
        for (int i=0;i<N+1;i++) {
            for (int j=0;j<arr[i].size();j++) {
                System.out.print(arr[i].get(j) + " " );
            }
            System.out.println();
        }
    }

    static void count() {
        int day = 1;
        for (int i=1;i<=N;i++) {
            for (int j=0;j<arr[i].size();j++) {
                if (day <= i) {
                    answer += arr[i].get(j);
                    q.add(arr[i].get(j));
                    day++;
                }
                else {
                    int qTop = q.peek();
                    if (qTop < arr[i].get(j)) {
                        answer -= q.poll();
                        q.add(arr[i].get(j));
                        answer += arr[i].get(j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        sortByCups();
        count();
        System.out.println(answer);
    }
}