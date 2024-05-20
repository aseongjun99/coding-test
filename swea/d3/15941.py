# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYVgOZEKOpcDFAQK&categoryId=AYVgOZEKOpcDFAQK&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    print('#%d'%tc, n*n)