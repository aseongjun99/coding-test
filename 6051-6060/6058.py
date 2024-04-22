# https://codeup.kr/problem.php?id=6058

a, b = map(int, input().split())
print(not(bool(a) or bool(b)))

# 정답 1
# a, b = input().split()
# c= bool(int(a))
# d= bool(int(b))
#
# print( not (c or d) )
#
# 정답 2
# a, b = input().split()
# c= bool(int(a))
# d= bool(int(b))
#
# print( c==False and d==False )
