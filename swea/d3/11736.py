# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXhh-H-KwUcDFARQ&categoryId=AXhh-H-KwUcDFARQ&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    nums = list(map(int, input().split()))
    answer = 0
    # i-1, i, i+1 비교
    for i in range(1, n-1):
        iNums = nums[i-1:i+2]
        if iNums[1] != min(iNums) and iNums[1] != max(iNums):
            answer += 1

    print('#%d'%tc, answer)
