import java.util.*;
import java.io.*;

class Solution {
    
    static int zero = 0;
    static int one = 0;
    
    static void compress(int y, int x, int boxSize, int[][] arr) {
        int number = arr[y][x];
        boolean flag = false;
        for (int i=y;i<y+boxSize;i++) {
            for (int j=x;j<x+boxSize;j++) {
                if (number != arr[i][j]) {
                    flag = true;
                    break;
                }
            }
        }
        
        if (!flag) {
            if (number == 0) {
                zero++;
            }
            else {
                one++;
            }
        }
        else {
            int newBoxSize = boxSize/2;
            compress(y, x, newBoxSize, arr);
            compress(y+newBoxSize, x, newBoxSize, arr);
            compress(y, x+newBoxSize, newBoxSize, arr);
            compress(y+newBoxSize, x+newBoxSize, newBoxSize, arr);
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int boxSize = arr.length;
        
        compress(0, 0, boxSize, arr);
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
}