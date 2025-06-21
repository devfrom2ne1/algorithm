class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        int a = arr1.length;        
        int b = arr1[0].length;
        int c = arr2[0].length;
        
        answer = new int[a][c];
        
        for(int i=0; i<a; i++)
        {
            for(int j=0; j<c; j++)
            {
                int k = getValue(arr1, arr2, i, j, b);
                answer[i][j] = k;
            }
        }
        
        return answer;
    }
    public int getValue(int[][] arr1, int[][] arr2, int x, int y, int b){
        int val = 0;
        
        for(int i=0; i<b; i++){
            val += arr1[x][i] * arr2[i][y];
        }
        
        return val;
    }    
}