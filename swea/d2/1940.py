# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PjMgaALgDFAUq&categoryId=AV5PjMgaALgDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3

t = int(input()) + 1
for tc in range(1, t):
    n = int(input())
    # command = 0 -> 유지, 1 -> 가속, 2 -> 감속
    command = []
    for i in range(n):
        command.append(list(map(int, input().split())))

    distance = 0
    speed = 0
    for i in range(len(command)):
        if command[i][0] == 1:
            speed += command[i][1]
            distance += speed
        elif command[i][0] == 2:
            speed -= command[i][1]
            # 현재 속도보다 감속이 더 크면 0
            if speed < 0:
                speed = 0
            distance += speed
        else:
            distance += speed

    print('#%d'%tc, distance)

