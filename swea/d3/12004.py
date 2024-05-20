# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXkcWgFa8sADFAS8&categoryId=AXkcWgFa8sADFAS8&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    available = False
    for i in range(2, 10):
        # n이 1이면 표현 가능함.
        if n == 1:
            available = True
            break
        # 10 미만의 숫자로 나누어 떨어지고, 그 몫이 10 이하라면 표현 가능.
        if n % i == 0 and n / i < 10:
            available = True
            break

    if available:
        print('#%d'%tc, 'Yes')
    else:
        print('#%d'%tc, 'No')