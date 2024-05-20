# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYxCRFA6iiEDFASu&categoryId=AYxCRFA6iiEDFASu&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    prices = list(map(int, input().split()))

    # 첫 번째 원소는 무조건 할인된 가격
    answer = []
    # 할인된 가격의 개수 = n
    count = 0 # 첫 번째 원소는 할인된 가격

    idx = 0
    while count < n:
        if prices[idx] == -1:
            idx += 1
            continue

        regular_price = int(prices[idx] / 0.75)
        if regular_price in prices:
            count += 1
            answer.append(prices[idx])
            prices[idx] = -1
            prices[prices.index(regular_price)] = -1
        idx += 1

    print('#%d'%tc, end=' ')
    for ans in answer:
        print(ans, end=' ')
    print()