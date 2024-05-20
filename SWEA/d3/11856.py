# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXjS1GXqZ8gDFATi&categoryId=AXjS1GXqZ8gDFATi&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=2

t = int(input()) + 1
for tc in range(1, t):
    s = input()
    yes = True
    # str -> list -> set 의 과정을 거친 후 길이가 2가 아니라면 No
    checkAppearance = set(list(s))
    if len(checkAppearance) != 2:
        yes = False
    else:
        # 각 문자가 정확히 2번 등장하는지 확인
        c1 = checkAppearance.pop()
        c2 = checkAppearance.pop()
        num1 = s.count(c1)
        num2 = s.count(c2)
        if num1 != 2 or num2 != 2:
            yes = False

    if yes:
        print('#%d'%tc, 'Yes')
    else:
        print('#%d'%tc, 'No')
