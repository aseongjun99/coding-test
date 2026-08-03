import java.util.*;
import java.io.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i]+1;
            }
            else {
                boolean flag = false;
                StringBuilder bit = new StringBuilder(Long.toString(numbers[i], 2));
                for (int j=bit.length()-1;j>0;j--) {
                    if (bit.charAt(j-1) == '0' && bit.charAt(j) == '1') {
                        bit.setCharAt(j-1, '1');
                        bit.setCharAt(j, '0');
                        answer[i] = Long.parseLong(bit.toString(), 2);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    bit.setCharAt(0, '0');
                    bit.insert(0, '1');
                    answer[i] = Long.parseLong(bit.toString(), 2);
                }
            }
        }
        
        return answer;
    }
}