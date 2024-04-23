# https://codeup.kr/problem.php?id=6081

c = int(input(), 16)
for i in range(1, 16):
    print('%X'%c, '*', '%X'%i, '=', '%X'%(c*i), sep='')

# 정답
# n = int(input(), 16)
#
# for i in range(1, 16):
#     print('%X' % n, '*%X' % i, '=%X' % (n * i), sep='')
#
# '''
# 또는
# print("%X*%X=%X"%(n,i,n*i))
#
# '''
