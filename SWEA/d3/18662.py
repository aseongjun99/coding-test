# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYo-e9EKmGoDFAQI&categoryId=AYo-e9EKmGoDFAQI&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    x, y, z = map(int, input().split())

    print('#%d'%tc, end=' ')
    diff1, diff2 = y - x, z - y

    # 이미 등차수열인 경우
    if diff1 == diff2:
        print(0.0)
    else:
        if diff1 > diff2:
            print(format((diff1 - diff2) / 2, '.1f'))
        else:
            print(format((diff2 - diff1) / 2, '.1f'))
