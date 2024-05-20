# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

T = int(input()) + 1
for tc in range(1, T):
    word = input()
    check = 1
    for i in range(len(word)//2 + 1):
        # 단어의 맨 왼쪽, 맨 오른쪽부터 한 글자씩 비교
        # 하나라도 다른게 있다면 회문이 아님.
        if word[i] != word[len(word) - 1 - i]:
            check = 0
            break

    print('#%d'%tc, check)