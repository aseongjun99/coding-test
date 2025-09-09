import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int[][] gear;
    static int K;
    static boolean[] rotationFlag;

    static void checkRotation(int target) {
        for (int i=target-1;i>0;i--) {
            if (rotationFlag[i+1] && (gear[i][2] != gear[i+1][6])) {
                rotationFlag[i] = true;
            }
            else {
                break;
            }
        }
        for (int i=target+1;i<=T;i++) {
            if (rotationFlag[i-1] && (gear[i][6] != gear[i-1][2])) {
                rotationFlag[i] = true;
            }
            else {
                break;
            }
        }
    }

    static void rotate(int idx, int target, int dir) {
        int diff = Math.abs(target - idx);
        if (diff % 2 == 0) {
            if (dir == 1) {
                clockwise(idx);
            }
            else if (dir == -1) {
                counterclockwise(idx);
            }
        }
        else {
            if (dir == 1) {
                counterclockwise(idx);
            }
            else {
                clockwise(idx);
            }
        }
    }

    static void clockwise(int idx) {
        int temp = gear[idx][7];
        for (int i=7;i>=1;i--) {
            gear[idx][i] = gear[idx][i-1];
        }
        gear[idx][0] = temp;
    }

    static void counterclockwise(int idx) {
        int temp = gear[idx][0];
        for (int i=0;i<=6;i++) {
            gear[idx][i] = gear[idx][i+1];
        }
        gear[idx][7] = temp;
    }

    static int countS() {
        int count = 0;
        for (int i=1;i<=T;i++) {
            if (gear[i][0] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        gear = new int[T+1][8];
        for (int i=1;i<=T;i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j=0;j<8;j++) {
                gear[i][j] = temp[j] - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int k=0;k<K;k++) {
            rotationFlag = new boolean[T+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotationFlag[target] = true;
            checkRotation(target);
            for (int i=1;i<=T;i++) {
                if (rotationFlag[i]) {
                    rotate(i, target, dir);
                }
            }
        }

        System.out.println(countS());
    }
}