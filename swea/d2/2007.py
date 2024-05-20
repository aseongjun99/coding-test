# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

T = int(input()) + 1
for tc in range(1, T):
    string = input()
    num = 0
    for i in range(1, 10):
        if string[:i] == string[i:i+i]:
            print('#%d'%tc, i)
            break
