
import java.util.*;
import java.io.*;

public class Main {

	static int[] numbers = new int[5];
	static String[] colors = new String[5];
	static int answer = 0;
	
	static boolean one() {
		String color = colors[0];
		for (int i=1;i<5;i++) {
			if (!colors[i].equals(color)) {
				return false;
			}
		}
		
		int[] temp = new int[5];
		temp = Arrays.copyOf(numbers, 5);
		
		Arrays.sort(temp);
		for (int i=1;i<5;i++) {
			if (temp[i] - temp[i-1] != 1) {
				return false;
			}
		}
		
		answer = temp[4] + 900;
		return true;
	}
	
	static boolean two() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<5;i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			} else {
				map.put(numbers[i], 1);				
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 4) {
				answer = entry.getKey() + 800;
				return true;
			}
		}
	
		return false;
	}
	
	static boolean three() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<5;i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			} else {
				map.put(numbers[i], 1);
			}
		}
		
		if (map.values().contains(3) && map.values().contains(2)) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() == 3) {
					answer += entry.getKey() * 10;
				} else if (entry.getValue() == 2) {
					answer += entry.getKey();
				}
			}
			answer += 700;
			return true;
		}
		
		return false;
	}
	
	static boolean four() {
		int maxNumber = numbers[0];
		for (int i=1;i<5;i++) {
			if (!colors[i].equals(colors[i-1])) {
				return false;
			}
			maxNumber = Math.max(maxNumber, numbers[i]);
		}
		
		answer = maxNumber + 600;
		return true;
	}
	
	static boolean five() {
		int[] temp = new int[5];
		temp = Arrays.copyOf(numbers, 5);
		Arrays.sort(temp);
		for (int i=1;i<5;i++) {
			if (temp[i] - temp[i-1] != 1) {
				return false;
			}
		}
		
		answer = temp[4] + 500;
		return true;
	}
	
	static boolean six() {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<5;i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			} else {
				map.put(numbers[i], 1);
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 3) {
				answer = entry.getKey() + 400;
				return true;
			}
		}
		
		return false;
	}
	
	static boolean seven() {
		int[] num = new int[10];
		for (int i=0;i<5;i++) {
			num[numbers[i]] += 1;
		}
		
		int twoCount = 0;
		int smallTwo = 0;
		int bigTwo = 0;
		for (int i=0;i<10;i++) {
			if (num[i] == 2) {
				if (twoCount == 0) {
					smallTwo = i;
					twoCount++;
				} else {
					bigTwo = i;
					twoCount++;
					break;
				}
			}
		}
		
		if (twoCount != 2) {
			return false;
		}
		
		answer = bigTwo * 10 + smallTwo + 300;
		return true;
	}
	
	static boolean eight() {
		int[] num = new int[10];
		for (int i=0;i<5;i++) {
			num[numbers[i]] += 1;
		}
		
		for (int i=0;i<10;i++) {
			if (num[i] == 2) {
				answer = i + 200;
				return true;
			}
		}
		
		return false;
	}
	
	static boolean nine() {
		Arrays.sort(numbers);
		answer = numbers[4] + 100;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			colors[i] = st.nextToken();
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		if (one()) {
			System.out.println(answer);
		} else if (two()) {
			System.out.println(answer);
		} else if (three()) {
			System.out.println(answer);
		} else if (four()) {
			System.out.println(answer);
		} else if (five()) {
			System.out.println(answer);
		} else if (six()) {
			System.out.println(answer);
		} else if (seven()) {
			System.out.println(answer);
		} else if (eight()) {
			System.out.println(answer);
		} else if (nine()) {
			System.out.println(answer);
		}
	}
}
