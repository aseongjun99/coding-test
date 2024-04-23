# https://codeup.kr/problem.php?id=6064

a, b, c = map(int, input().split())

print((a if a < b else b) if ((a if a < b else b) < c) else c)

# 정답
# a, b, c = input().split()
# a = int(a)  #변수 a에 저장되어있는 값을 정수로 바꾸어 다시 변수 a에 저장
# b = int(b)
# c = int(c)
#
# d = a if a<b else b
# e = d if d<c else c
#
# print(e)
