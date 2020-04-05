package G20200343040039

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}
	numberOfRow := len(matrix)
	numberOfCol := len(matrix[0])

	row, col := numberOfRow-1, 0
	for row >= 0 && col < numberOfCol{
		if matrix[row][col]==target{ //2.找到则返回
			return true
		}else if matrix[row][col]<target{ //3.小于target，向右查找
			col++
		}else{                      //4.大于target，向上查找
			row--
		}
	}

	return false
}