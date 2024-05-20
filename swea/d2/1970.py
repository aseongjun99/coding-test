# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    count_list = [0, 0, 0, 0, 0, 0, 0, 0]
    # 큰 금액의 돈부터 나누기
    for i in range(len(money)):
        count_list[i] = n // money[i]
        n %= money[i]

    print('#%d'%tc)
    for count in count_list:
        print(count, end=' ')
    print()
