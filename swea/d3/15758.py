# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYP5JmsqcngDFATW&categoryId=AYP5JmsqcngDFATW&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    s, t = map(str, input().split())
    # 길이가 같으면 문자열이 같은지 확인하면 됨.
    if len(s) == len(t):
        if s == t:
            print('#%d'%tc, 'yes')
        else:
            print('#%d'%tc, 'no')
    else:
        # 편의를 위해 항상 s가 더 길도록.
        if len(s) < len(t):
            s, t = t, s

        # aaba, aab 같은 경우를 위해 s 또한 한 번더 이어붙임
        s += s
        # t가 s보다 길어지도록 이어붙임
        t *= (len(s)//len(t)+1)
        # s가 t안에 있으면 yes
        if s in t:
            print('#%d'%tc, 'yes')
        else:
            print('#%d'%tc, 'no')
