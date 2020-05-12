public class LeetCode_1122_0215 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int m[]   = new int [1001];
        int[] result = new int [arr1.length];
        for (int i=0;i<arr1.length;i++){
            m[arr1[i]]++;
        }

        int count =0;
        for (int j=0;j<arr2.length;j++){
            while (m[arr2[j]]>0){
                result[count++]=arr2[j];
                m[arr2[j]]--;
            }
        }
        for (int k=0;k<m.length;k++){
            while (m[k]>0){
                result[count++]=k;
                m[k]--;
            }
        }
        return result;

    }
}
