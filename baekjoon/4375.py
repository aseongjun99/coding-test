# https://www.acmicpc.net/problem/4375

while True:
    try:
        n = int(input())
    except:
        break

    # 문자열 1부터 1씩 자릿수를 늘려가며 확인
    s = '1' * len(str(n))
    while True:
        if int(s)%n == 0:
            break
        s += '1'

    print(len(s))