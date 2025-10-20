import java.util.*;
import java.io.*;
class Solution {
    
    static int calcMaxLength(int y, int x, String[][] park) {
        int l = 1;
        while ((y+l) <= park.length && (x+l) <= park[0].length) {
            for (int i=y;i<y+l;i++) {
                for (int j=x;j<x+l;j++) {
                    if (!park[i][j].equals("-1")) {
                        return l-1;
                    }
                }
            }
            l++;
        }
        return l-1;
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int maxLength = 0;
        Arrays.sort(mats);
        for (int i=0;i<park.length;i++) {
            for (int j=0;j<park[i].length;j++) {
                if (park[i][j].equals("-1")) {
                    maxLength = Math.max(maxLength, calcMaxLength(i, j, park));
                }
            }
        }
        
        for (int i=mats.length-1;i>=0;i--) {
            if (maxLength >= mats[i]) {
                return mats[i];
            }
        }
        
        return -1;
    }
}