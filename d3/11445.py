# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXdHwI1aCy0DFAS5&categoryId=AXdHwI1aCy0DFAS5&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    p = input().strip()
    q = input().strip()

    if p+'a' == q:
        print('#%d'%tc, 'N')
    else:
        print('#%d'%tc, 'Y')
