# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX6PP9G6p1sDFAS9&categoryId=AX6PP9G6p1sDFAS9&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    s = input()

    # 입력받은 문자열에서 o 개수 찾기
    count = s.count('o')
    if len(s) + (8 - count) > 15:
        print('#%d'%tc, 'NO')
    else:
        print('#%d'%tc, 'YES')
