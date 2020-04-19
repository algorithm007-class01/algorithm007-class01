func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix)==0{
        return false
    }
    row:=len(matrix)
    col:=len(matrix[0])

    i,j:=row-1,0
    for i>=0 && j<col{
        if matrix[i][j]==target{ 
            return true
        }else if matrix[i][j]<target{ 
            j++
        }else{                      
            i--
        }
    }

    return false
}