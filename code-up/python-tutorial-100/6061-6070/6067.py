# https://codeup.kr/problem.php?id=6067

num = int(input())
if num < 0:
    if num % 2 == 0:
        print("A")
    else:
        print("B")
else:
    if num % 2 == 0:
        print("C")
    else:
        print("D")

# 정답
# n=int(input())
#
# if n<0:
#   if n%2==0:
#     print('A')
#   else:
#     print('B')
# else:
#   if n%2==0:
#     print('C')
#   else:
#     print('D')