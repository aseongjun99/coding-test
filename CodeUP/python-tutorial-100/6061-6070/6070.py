# https://codeup.kr/problem.php?id=6070

month = int(input())
check = month // 3
if check == 4 or check == 0:
    print('winter')
elif check == 1:
    print('spring')
elif check == 2:
    print('summer')
else:
    print('fall')

# 정답
# a=int(input())
# if a//3==1:
#     print("spring")
# elif a//3==2:
#     print("summer")
# elif a//3==3:
#     print("fall")
# else:
#     print("winter")
