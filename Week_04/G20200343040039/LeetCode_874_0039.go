package G20200343040039

func robotSim(commands []int, obstacles [][]int) int {
	type point struct{
		x int
		y int
	}

	obstaclesCache := make(map[point]struct{})

	directionX := []int{0, -1, 0, 1}
	directionY := []int{1, 0, -1, 0}

	for i := 0; i < len(obstacles); i++ {
		obsPoint := point{obstacles[i][0], obstacles[i][1]}
		obstaclesCache[obsPoint] = struct{}{}
	}

	dir := 0
	curPointX := 0
	curPointY := 0
	nextPointX := 0
	nextPointY := 0
	res := 0
	// []int{4,-1,4,-2,4}
	// [][]int{{2,4}})
	for i := 0; i < len(commands); i++ {
		if commands[i] == -1 {
			dir = (dir + 4 - 1) % 4
		} else if commands[i] == -2 {
			dir= (dir + 1) % 4
		} else {
			for step := 1; step <= commands[i]; step++ {
				if _, ok := obstaclesCache[point{curPointX + directionX[dir], curPointY + directionY[dir]}]; !ok {
					nextPointX = curPointX + directionX[dir]
					nextPointY = curPointY + directionY[dir]

					curPointX, curPointY = nextPointX, nextPointY

					if res < curPointX*curPointX + curPointY*curPointY {
						res = curPointX*curPointX + curPointY*curPointY
					}
				}
			}


		}
	}

	return res
}