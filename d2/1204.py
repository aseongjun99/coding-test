# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=2&pageSize=10&pageIndex=3

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    students = list(map(int, input().split()))
    # 0~100까지의 인덱스를 가진 리스트 생성
    # 각 점수가 몇 번 나오는 지 카운트
    scores = [0] * 101
    for i in range(len(students)):
        scores[students[i]] += 1

    # 가장 많이 나온 점수의 인덱스 확인
    # 이때, 최빈값이 여러개일 수 있음. 그때는 가장 큰 값
    # mode = scores.index(max(scores))
    modes = list(filter(lambda x : scores[x] == max(scores), range(len(scores))))
    print('#%d'%tc, modes[-1])
