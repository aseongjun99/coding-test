
import java.util.*;
import java.io.*;

public class Main {

	static int H, W;
	static int[] arr;
	
	static boolean checkLeft(int idx, int num) {
		for (int i=idx-1;i>=0;i--) {
			if (arr[i] >= num) {
				return true;
			}
		}
		return false;
	}
	
	static boolean checkRight(int idx, int num) {
		for (int i=idx+1;i<arr.length;i++) {
			if (arr[i] >= num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<W;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int rain = 0;
		for (int i=1;i<arr.length-1;i++) {
			int count = 1;
			while (true) {
				int num = arr[i] + count;
				if (num > H) {
					count--;
					break;
				}
				if (checkLeft(i, num) && checkRight(i, num)) {
					count++;
				}
				else {
					count--;
					break;
				}
			}
			rain += count;
		}
		
		System.out.println(rain);
	}
}
