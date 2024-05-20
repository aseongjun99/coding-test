# https://codeup.kr/problem.php?id=6087

n = int(input())
for i in range(1, n+1):
    if i % 3 == 0:
        continue
    print(i, end=' ')

# 정답
# n=int(input())
#
# for i in range(1, n+1) :
#   if i%3==0 :
#     continue            #다음 반복 단계로 넘어간다.
#   print(i, end=' ')    #i가 짝수가 아닐 때만 실행된다.
