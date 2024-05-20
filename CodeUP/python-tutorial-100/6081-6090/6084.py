# https://codeup.kr/problem.php?id=6084

h, b, c, s = map(int, input().split())
print(round((h*b*c*s)/8/1024/1024,1), 'MB')

# 정답
# h, b, c, s = input().split()
#
# h = int(h)
# b = int(b)
# c = int(c)
# s = int(s)
#
# print(round(h*b*c*s/8/1024/1024, 1), "MB")
#
