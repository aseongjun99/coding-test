# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AX4EJPs68IkDFARe&categoryId=AX4EJPs68IkDFARe&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=3&pageSize=30&pageIndex=1

t = int(input()) + 1
for tc in range(1, t):
    n = input()

    minCheck = list(n)
    maxCheck = list(n)

    minNum = n
    maxNum = n

    # 2중 for문 돌면서 하나씩 스왑하며 비교
    for i in range(len(n)-1):
        for j in range(i, len(n)):
            minTemp = minCheck[:]
            maxTemp = maxCheck[:]

            minTemp[i], minTemp[j] = minTemp[j], minTemp[i]
            maxTemp[i], maxTemp[j] = maxTemp[j], maxTemp[i]

            if maxNum < ''.join(maxTemp):
                maxNum = ''.join(maxTemp)
            if minTemp[0] == '0':
                continue
            if minNum > ''.join(minTemp):
                minNum = ''.join(minTemp)

    print('#%d'%tc, minNum, maxNum)
