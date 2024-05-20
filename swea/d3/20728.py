# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AY6cg0MKeVkDFAXt&categoryId=AY6cg0MKeVkDFAXt&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1
from itertools import combinations

t = int(input()) + 1
for tc in range(1, t):
    # 주머니의 개수 n, 나눠 줄 주머니 개수 k
    n, k = map(int, input().split())

    # 사탕 개수
    candy_nums = list(map(int, input().split()))

    # 런타임 에러 뜨는 코드
    # # n == k 인 경우 사탕의 최댓값과 최솟값의 차이를 출력하면 된다.
    # if n == k:
    #     print('#%d'%tc, max(candy_nums) - min(candy_nums))
    # else:
    #     # 조합 구하기
    #     comb = list(combinations(candy_nums, k))
    #     diff = []
    #     for i in range(len(comb)):
    #         diff.append(max(comb[i]) - min(comb[i]))
    #     diff.sort()
    #     print('#%d'%tc, diff[0])

    # 사탕 개수 정렬 후, 사탕[-1] - 사탕[-1-k] = 최소값
    candy_nums.sort(reverse=True)
    diff_min = 999999999
    for i in range(len(candy_nums) - k + 1):
        diff_min = min(diff_min, candy_nums[i] - candy_nums[i + k-1])

    print('#%d'%tc, diff_min)
