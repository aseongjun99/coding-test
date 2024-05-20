# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AY2hjCWKbykDFATh&categoryId=AY2hjCWKbykDFATh&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

def palindrome(s):
    # 회문인지 체크
    check = 0
    for i in range(len(s)//2):
        if s[i] != s[-1-i]:
            check = 1
            break
    if check == 1:
        return False
    return True


t = int(input()) + 1
for tc in range(1, t):
    s = input()
    if palindrome(s) == False:
        print('#%d'%tc, 'NO')
        continue
    else:
        # 처음 (n-1)/2글자가 회문인지 체크
        if palindrome(s[:(len(s) - 1) // 2]) == False:
            print('#%d' % tc, 'NO')
            continue
        else:
            # 마지막 (n-1)/2글자가 회문인지 체크
            if palindrome(s[(len(s) - 1) // 2 + 1:]) == False:
                print('#%d' % tc, 'NO')
                continue
            else:
                print('#%d' % tc, 'YES')
                continue