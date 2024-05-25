# https://www.acmicpc.net/problem/2309

from itertools import combinations

# 아홉 난쟁이 키 입력
height = [int(input()) for _ in range(9)]
# 7명 키 조합 추출
sums = combinations(height, 7)
# 키의 합 == 100 이면 정답.
list_sums = list(sums)
answer = []
for i in range(len(list_sums)):
    if sum(list_sums[i]) == 100:
        answer = list(list_sums[i])

answer.sort()
for a in answer:
    print(a)