# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PwGK6AcIDFAUq&categoryId=AV5PwGK6AcIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    grade_list = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    # 입력
    n, k = map(int, input().split())
    # n 명의 학생 점수 입력 및 비율 반영
    scores = []
    for i in range(n):
        mid, fin, assign = map(int, input().split())
        scores.append((mid*0.35) + (fin*0.45) + (assign*0.2))

    # 정렬된 점수 리스트 생성
    sorted_scores = sorted(scores, reverse=True)

    # k 번째 학생의 등수 확인
    rank = sorted_scores.index(scores[k-1])

    grade = grade_list[int(rank//(n/10))]
    print('#%d'%tc, grade)