package G20200343040161

import "strconv"

func updateBoard(board [][]byte, click []int) [][]byte {
	if board[click[0]][click[1]]=='M' {
		board[click[0]][click[1]]='X'
		return board
	}
	if board[click[0]][click[1]]=='E'{
		nums:=checkAround(board,click[0],click[1])
		if nums!=0 {
			s:=strconv.Itoa(nums)
			board[click[0]][click[1]]=s[0]
		}else{
			board[click[0]][click[1]]='B'
			next:=[][]int{{click[0],click[1]}}
			for len(next)!=0{
				temp:=next[0]
				for i:=-1;i<2;i++{
					for j:=-1;j<2;j++{
						if 0<=temp[0]+i&&
							temp[0]+i<len(board)&&
							0<=temp[1]+j&&
							temp[1]+j<len(board[0])&&
							board[temp[0]+i][temp[1]+j]=='E' {

							numt:=checkAround(board,temp[0]+i,temp[1]+j)
							if numt!=0 {
								s:=strconv.Itoa(numt)
								board[temp[0]+i][temp[1]+j]=s[0]
							}else{
								board[temp[0]+i][temp[1]+j]='B'
								next=append(next, []int{temp[0]+i,temp[1]+j})
							}

						}
					}
				}
				next=next[1:]
			}

		}
	}
	return board
}

func checkAround(board [][]byte,m,n int) int{
	res:=0
	for i:=-1;i<2;i++{
		for j:=-1;j<2;j++{
			if 0<=m+i&&m+i<len(board)&&0<=n+j&&n+j<len(board[0])&&board[m+i][n+j]=='M' {
				res++
			}
		}
	}
	return res
}