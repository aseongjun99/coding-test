# https://www.acmicpc.net/problem/1037

n = int(input())
nums = list(map(int, input().split()))

print(min(nums) * max(nums))
# nums.sort()
# print(nums[0] * nums[-1])