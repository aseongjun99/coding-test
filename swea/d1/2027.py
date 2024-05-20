# https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QFuZ6As0DFAUq&categoryId=AV5QFuZ6As0DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=PYTHON&select-1=1&pageSize=10&pageIndex=2

text = ['#','+','+','+','+']
print("".join(text))
for i in range(1, 5):
    text[i], text[i-1] = text[i-1], text[i]
    print("".join(text))