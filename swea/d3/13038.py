# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXxNn6GaPW4DFASZ&categoryId=AXxNn6GaPW4DFASZ&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    # 들으려는 수업 일 수
    n = int(input())
    # 수업 편성표
    classes = list(map(int, input().split()))

    answer = 987654321
    # 수업하는 날들의 인덱스 찾기
    idx = []
    for i in range(len(classes)):
        if classes[i] == 1:
            idx.append(i)

    # 각 인덱스로 시작할 경우 걸리는 일 수 계산
    # 최솟값 구하기
    for i in idx:
        startIndex = i
        days = 0
        classCount = 0
        while classCount != n:
            if classes[startIndex] == 1:
                classCount += 1
            days += 1
            startIndex += 1
            if startIndex == 7:
                startIndex = 0
        if days < answer:
            answer = days


    print('#%d'%tc, answer)