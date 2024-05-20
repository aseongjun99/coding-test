# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYzIZNkq-v4DFAQ9&categoryId=AYzIZNkq-v4DFAQ9&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n, m = map(int, input().split())
    # n개의 문자열
    s = list(map(str, input().split()))
    # m 개의 문자열
    t = list(map(str, input().split()))

    q = int(input())
    # 이름을 알고 싶은 년도 q개
    y = []
    for i in range(q):
        y.append(int(input()))

    answer = []

    # 알고자 하는 년도 % 문자열의 길이 + 1 = 년도 이름
    for year in y:
        answer.append(s[year%n-1] + t[year%m-1])

    print('#%d'%tc, end=' ')
    for ans in answer:
        print(ans, end=' ')
    print()