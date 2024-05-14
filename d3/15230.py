# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYLnMQT6vPADFATf&categoryId=AYLnMQT6vPADFATf&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    a = input()
    alphabets = 'abcdefghijklmnopqrstuvwxyz'

    # 입력받은 문자열에서 한 글자씩 이어붙여가며 알파벳과 비교
    answer = 0
    for i in range(len(a)):
        if a[:i+1] != alphabets[:i+1]:
            break
        answer = i + 1
    print('#%d'%tc, answer)