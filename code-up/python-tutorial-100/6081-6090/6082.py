# https://codeup.kr/problem.php?id=6082

n = input()
for i in range(1, int(n)+1):
    if '3' in str(i) or '6' in str(i) or '9' in str(i):
        print('X', end=' ')
    else:
        print(i, end=' ')

# 정답
# n = int(input())
#
# for i in range(1, n+1) :
#   if i%10==3 or i%10==6 or i%10==9 :
#     print("X", end=' ')
#   else :
#     print(i, end=' ')