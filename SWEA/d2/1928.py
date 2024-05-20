# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PR4DKAG0DFAUq&categoryId=AV5PR4DKAG0DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3

t = int(input()) + 1
encoding = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
for tc in range(1, t):
    string = input()
    # 값 저장하기
    value = []
    for i in range(len(string)):
        value.append(encoding.find(string[i]))

    # 저장한 값을 6비트 2진수로 표현하기
    # 이때, 한 값당 6자리 2진수로 표현해야 하며,
    # 표현한 2진수를 다시 8개씩 나누어야 함.
    binary = []
    for v in value:
        binary.append(format(v, 'b').zfill(6))
    bin_all = ''.join(binary)

    # 8개씩 나누기
    bin_div = [''] * (len(bin_all) // 8)
    for i in range(len(bin_all)):
        bin_div[i//8] += bin_all[i]

    # 10진수로 변환
    dec = []
    for bin in bin_div:
        dec.append(int(bin, 2))

    print('#%d'%tc, end=' ')
    for d in dec:
        print(chr(d), end='')
    print()
