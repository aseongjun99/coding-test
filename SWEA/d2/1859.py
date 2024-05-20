# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=1

# T = int(input()) + 1
# for tc in range(1, T):
#     n = int(input())
#     prices = list(map(int, input().split()))
#     sum = 0
#     while len(prices) > 0:
#         max_price = max(prices)
#         max_index = prices.index(max_price)
#         for i in range(max_index):
#             sum += (max_price - prices[i])
#         prices = prices[max_index:]
#         prices.pop(0)
#     print('#%d'%tc,sum)

T = int(input()) + 1
for tc in range(1, T):
    n = int(input())
    prices = list(map(int, input().split()))
    sum = 0
    max_prices = prices[-1]
    for i in range(len(prices)-2, -1, -1):
        if max_prices > prices[i]:
            sum += (max_prices - prices[i])
        else:
            max_prices = prices[i]
    print('#%d'%tc, sum)