import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int N;
    static List<String> list = new ArrayList<>();

    static void findExpression(int num, int sum, StringBuilder sb, int flag) {
        if (num > N) {
            if (sum == 0) {
                list.add(sb.toString());
            }
            return;
        }

        // ' '
        sb.append(" ").append(num);
        // sb.setCharAt(sb.length()-2, ' ');
        if (flag == 2) {
            int num2 = (num-1) * 10 + num;
            findExpression(num+1, (sum-(num-1))+num2, sb, 1);
        }
        else if (flag == 3) {
            int num2 = (num-1) * 10 + num;
            findExpression(num+1, (sum+(num-1))-num2, sb, 1);
        }
        else {
            findExpression(num+1, sum*10+num, sb, flag);
        }
        // +
        // sb.append("+").append(num);
        sb.setCharAt(sb.length()-2, '+');
        findExpression(num+1, sum+num, sb, 2);

        // -
        sb.setCharAt(sb.length()-2, '-');
        findExpression(num+1, sum-num, sb, 3);

        sb.delete(sb.length()-2, sb.length());
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(1);

            findExpression(2, 1, sb, 1);
            Collections.sort(list);
            for (int i=0;i<list.size();i++) {
                answer.append(list.get(i)).append("\n");
            }
            list.clear();
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }
}