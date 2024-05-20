# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AYtrCJQaDb4DFAR-&categoryId=AYtrCJQaDb4DFAR-&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=10&pageIndex=1

def palindrome(string):
    if string != string[::-1]:
            return False
    return True

t = int(input()) + 1
for tc in range(1, t):
    n, m = map(int, input().split())
    strings = [input() for i in range(n)]
    answer = 0

    # 이미 팰린드롬인 문자열들이 있으면, 그 중 하나만 쓸 수 있음.
    for i in range(len(strings)):
        if palindrome(strings[i]):
            answer = m
            break

    # 한 문자열을 뒤집은 문자열이 같이 존재하면 추가
    # 예를 들어, abc, cba 의 경우.
    for i in range(len(strings)):
        if strings[i][::-1] in strings:
            if strings[i][::-1] == strings[i]: # 자기 자신 제외(팰린드롬)
                continue
            answer += m

    print('#%d'%tc, answer)