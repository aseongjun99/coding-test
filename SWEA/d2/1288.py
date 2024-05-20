# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV18_yw6I9MCFAZN&categoryId=AV18_yw6I9MCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3

t = int(input()) + 1
for tc in range(1, t):
    n = int(input()) # 입력받은 n
    kn = n # n씩 더해갈 숫자
    check = [False] * 10 # 모든 숫자를 보게되는지 확인
    while False in check:
        # 각 자릿수 숫자 확인
        temp = kn
        while temp > 0:
            check[temp % 10] = True
            temp //= 10
        kn += n

    print('#%d'%tc, kn-n)