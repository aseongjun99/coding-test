import java.util.*;

class Solution {
    
    static void diceCombination(List<List<Integer>> diceCombList, List<Integer> comb, int diceNums, int limit, int index) {
        if (comb.size() == limit) {
            List<Integer> copy = new ArrayList<>();
            for (int i=0;i<comb.size();i++) {
                copy.add(comb.get(i));
            }
            diceCombList.add(copy);
            return;
        }
        
        for (int i=index;i<diceNums;i++) {
            comb.add(i);
            diceCombination(diceCombList, comb, diceNums, limit, i+1);
            comb.remove(comb.size()-1);
        }
    }
    
    static List<Integer> add(List<Integer> diceSum, int index, int[][] dice) {
    	List<Integer> res = new ArrayList<>();
    	for (int i=0;i<diceSum.size();i++) {
    		for (int j=0;j<dice[index].length;j++) {
    			res.add(diceSum.get(i) + dice[index][j]);
    		}
    	}
    	return res;
    }
    
public static int[] solution(int[][] dice) {
		// 주사위 개수
		int diceNums = dice.length;

		// n/2개 주사위 추출
		List<List<Integer>> diceCombList = new ArrayList<>();
		diceCombination(diceCombList, new ArrayList<>(), diceNums, diceNums / 2, 0);

		// 추출한 주사위 순회하며 모든 합의 경우의 수 저장
		// 0 번째 vs n-1 번째, 1 번째 vs n-2 번째, ... 로 비교하면 된다.
		int maxWin = 0;
		int maxWinDicesIndex = -1;
		int maxLose = 0;
		int maxLoseDicesIndex = -1;
		for (int i = 0; i < diceCombList.size() / 2; i++) {
			List<Integer> aDices = diceCombList.get(i);
			List<Integer> bDices = diceCombList.get(diceCombList.size() - i - 1);
			List<Integer> diceSum1 = new ArrayList<>();
			List<Integer> diceSum2 = new ArrayList<>();

			// 최적화 필요
			for (int j = 0; j < aDices.size(); j++) {
				if (j == 0) {
					for (int k = 0; k < dice[aDices.get(j)].length; k++) {
						diceSum1.add(dice[aDices.get(j)][k]);
						diceSum2.add(dice[bDices.get(j)][k]);
					}
				} else {
					diceSum1 = add(diceSum1, aDices.get(j), dice);
					diceSum2 = add(diceSum2, bDices.get(j), dice);
				}
			}

			Collections.sort(diceSum1);
			Collections.sort(diceSum2);

			int win = 0;
			int lose = 0;
			for (int j = 0; j < diceSum1.size(); j++) {
				int left = 0;
				int right = diceSum1.size() - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (diceSum1.get(j) > diceSum2.get(mid)) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				win += left;
				
				left = 0;
				right = diceSum1.size() - 1;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (diceSum1.get(j) >= diceSum2.get(mid)) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				lose += diceSum2.size() - left;
			}

//            // 최적화 필요
//            for (int j=0;j<diceSum1.size();j++) {
//            	if ((win + (diceSum1.size()-j) * diceSum2.size() < maxWin) && (lose + (diceSum1.size()-j)*diceSum2.size() < maxLose)) {
//            		break;
//            	}
//            	for (int k=0;k<diceSum2.size();k++) {
//            		if (diceSum1.get(j) > diceSum2.get(k)) {
//            			win++;
//            		} else if (diceSum1.get(j) < diceSum2.get(k)) {
//            			lose++;
//            		}
//            	}
//            }

			if (maxWin < win) {
				maxWin = win;
				maxWinDicesIndex = i;
			}
			if (maxLose < lose) {
				maxLose = lose;
				maxLoseDicesIndex = diceCombList.size() - i - 1;
			}
		}

		int[] answer = new int[diceNums / 2];
		if (maxWin > maxLose) {
			for (int i = 0; i < diceNums / 2; i++) {
				answer[i] = diceCombList.get(maxWinDicesIndex).get(i) + 1;
			}
		} else if (maxWin < maxLose) {
			for (int i = 0; i < diceNums / 2; i++) {
				answer[i] = diceCombList.get(maxLoseDicesIndex).get(i) + 1;
			}
		}

		return answer;
	}
}