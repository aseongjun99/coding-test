T = int(input())
for _ in range(T):
    nums = list(map(int, input().split()))
    sum = 0
    for num in nums:
        if num % 2 == 1:
            sum += num
    print("#%d"%(_+1), sum)