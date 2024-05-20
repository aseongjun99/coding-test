# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYgEiwbKy48DFARP&categoryId=AYgEiwbKy48DFARP&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    s = input()

    if s[:len(s)//2] == s[len(s)//2:]:
        print('#%d'%tc, 'Yes')
    else:
        print('#%d' % tc, 'No')
