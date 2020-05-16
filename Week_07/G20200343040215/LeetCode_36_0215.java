import java.util.HashMap;

public class LeetCode_36_0215 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] columns = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];

        for (int i=0;i<9;i++){
            rows[i]=new HashMap<>();
            columns[i]=new HashMap<>();
            boxes[i]=new HashMap<>();
        }

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c = board[i][j];
                if (c!='.'){
                    int n=(int)c;
                    int box_index  = (i / 3 ) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n,0)+1);
                    columns[j].put(n, columns[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0)+1);
                    if (rows[i].get(n)>1 || columns[j].get(n)>1 || boxes[box_index].get(n)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
