# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PmkDKAOMDFAUq&categoryId=AV5PmkDKAOMDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    alphabet = []
    for i in range(n):
        alphabet.append(input().split())

    # 입력받은 알파벳을 한 문자열로 이어서 10개씩 출력
    string = ''
    for i in range(n):
        for j in range(int(alphabet[i][1])):
            string += alphabet[i][0]

    count = 0
    print('#%d'%tc)
    for i in range(len(string)):
        if count == 10:
            count = 0
            print()
        print(string[i],end='')
        count += 1
    print()