# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    m1, d1, m2, d2 = map(int, input().split())
    # 주의
    # 리스트의 원소가 0부터 시작해야함.
    # 1월의 마지막 날짜인 31부터 시작하면,
    # 1/1은 365일 중 1번째 날인데, 이를 32로 계산하게 된다.
    # 이는, 모든 달이 31이면 상관없지만, 그렇지 않기 때문에 주의.
    day = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30]
    # 두 번째 날짜가 첫 번째 날짜의 며칠
    # -> 두 번째 날짜 까지의 일 수 - 첫 번째 날짜 까지의 일 수 + 1
    day_sum1 = 0
    for i in range(m1):
        day_sum1 += day[i]
    day_sum1 += d1

    day_sum2 = 0
    for i in range(m2):
        day_sum2 += day[i]
    day_sum2 += d2

    print('#%d'%tc, day_sum2-day_sum1+1)

