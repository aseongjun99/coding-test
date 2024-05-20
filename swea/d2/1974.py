# https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

t = int(input()) + 1
for tc in range(1, t):
    puzzle = []
    for i in range(9):
        puzzle.append(list(map(int, input().split())))

    # 행, 열, 3x3 격자를 set에 넣었을 때 길이가 9면 됨.
    grid = [[] for i in range(9)]

    sudoku = 1

    for i in range(9):
        row = set(puzzle[i])
        col = set()
        for j in range(9):
            grid_index = (i // 3) * 3 + (j // 3)
            grid[grid_index].append(puzzle[i][j])
            col.add(puzzle[j][i])

        if len(row) != 9 or len(col) != 9:
            sudoku = 0
            break

    if sudoku == 1:
        for i in range(9):
            if len(set(grid[i])) != 9:
                sudoku = 0
                break

    print('#%d'%tc, sudoku)