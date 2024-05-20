# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QQ6qqA40DFAUq&categoryId=AV5QQ6qqA40DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=30&pageIndex=1

T = int(input())
for tc in range(T):
    a, b = map(int, input().split())
    if a > b:
        print('#%d'%(tc+1), '>')
    elif a == b:
        print('#%d'%(tc+1), '=')
    else:
        print('#%d'%(tc+1), '<')