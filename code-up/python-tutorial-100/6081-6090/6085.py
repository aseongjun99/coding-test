# https://codeup.kr/problem.php?id=6085

w, h, b = map(int, input().split())
print('%.2f'%(w*h*b/8/1024/1024), 'MB')

# 정답
# w,h,b = input().split()
# res=int(w)*int(h)*int(b)/1024/1024/8
#
# print('%.2f'%res,"MB")
