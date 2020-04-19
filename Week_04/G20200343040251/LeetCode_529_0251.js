/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    let m = board.length;
    let n = board[0].length;
    let queue = [click];
    while(queue.length != 0){
        let cell = queue.shift();
        let x = cell[0];
        let y = cell[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else{
            let count = 0;
            for(let i = -1;i < 2;i++){
                for(let j = -1;j < 2;j++){
                    if(i == 0 && j == 0){
                        continue;
                    }
                    let newX = x + i;
                    let newY = y + j;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                        continue;
                    }
                    if(board[newX][newY] == 'M' || board[newX][newY] == 'X'){
                        count++;
                    }
                }
            }
            if(count > 0){
                board[x][y] = count + '';
            }else{
                board[x][y] = 'B';
                for(let i = -1;i < 2;i++){
                    for(let j = -1;j < 2;j++){
                        if(i == 0 && j == 0){
                            continue;
                        }
                        let newX = x + i;
                        let newY = y + j;
                        if(newX < 0 || newX >= m || newY < 0 || newY >= n){
                            continue;
                        }
                        if(board[newX][newY] == 'E'){
                            queue.push([newX,newY]);
                            board[newX][newY] = 'B';
                        }
                    }
                }
            }
        }
    }
    return board;
  }