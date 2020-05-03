public class LeetCode_547_0145 {

    public int findCircleNum(int[][] M) {
        int peopleCount = M.length;
        //
        int[] visited = new int[peopleCount];

        int circleCount = 0;
        for (int curPeople = 0; curPeople < peopleCount; curPeople++){
            // 当前同学未统计过
            if (visited[curPeople] == 0){
                recursion(M, visited, curPeople, peopleCount);
                circleCount++;
            }
        }

        return circleCount;
    }

    private void recursion(int[][] M, int[] visited, int curPeople, int peopleCount){
        for (int recurPeople = 0; recurPeople < peopleCount; recurPeople++){
            if (M[curPeople][recurPeople] == 1 && visited[recurPeople] == 0){
                visited[recurPeople] = 1;
                recursion(M, visited, recurPeople, peopleCount);
            }
        }
    }

}
