# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    nums = list(map(int, input().split()))
    # 가장 작은 수와 가장 큰 수 제외
    nums.sort()
    avg = round(sum(nums[1:9]) / 8)

    print('#%d'%tc, avg)