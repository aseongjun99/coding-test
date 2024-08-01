import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static List<Integer> nums = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9)); 
	
	static void combination(int k, List<Integer> comb, List<List<Integer>> result) {
		if (comb.size() == k+1) {
			result.add(new ArrayList<>(comb));
		} else if (comb.size() < k+1) {
			for (int i=0;i<nums.size();i++) {
				int n = nums.get(i);
				comb.add(n);
				nums.remove(i);
				
				combination(k, comb, result);
				
				comb.remove(comb.size()-1);
				nums.add(i, n);
			}
		}
	}
	
	static boolean isAvailable(List<Integer> nums, String[] inequality) {
		for (int i=0;i<inequality.length;i++) {
			if (inequality[i].equals(">")) {
				if (nums.get(i) < nums.get(i+1)) {
					return false;
				}
			} else if (inequality[i].equals("<")) {
				if (nums.get(i) > nums.get(i+1)) {
					return false;
				}
			}
		}
		return true;
	}
	
	static String findMin(String[] inequality, List<List<Integer>> comb) {
		StringBuilder min = new StringBuilder();
		for (int i=0;i<comb.size();i++) {
			if (isAvailable(comb.get(i), inequality)) {
				for (int j=0;j<comb.get(i).size();j++) {
					min.append(comb.get(i).get(j));
				}
				break;
			}
		}
		return min.toString();
	}
	
	static String findMax(String[] inequality, List<List<Integer>> comb) {
		StringBuilder max = new StringBuilder();
		for (int i=comb.size()-1;i>-1;i--) {
			if (isAvailable(comb.get(i), inequality)) {
				for (int j=0;j<comb.get(i).size();j++) {
					max.append(comb.get(i).get(j));
				}
				break;
			}
		}
		return max.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		String[] inequality = br.readLine().split(" ");
		
		List<List<Integer>> comb= new ArrayList<>(); 
		combination(k, new ArrayList<>(), comb);

		System.out.println(findMax(inequality, comb));
		System.out.println(findMin(inequality, comb));
	}
}