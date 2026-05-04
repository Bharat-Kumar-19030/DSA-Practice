class Solution {
    public void rotate(int[][] mat) {
        for(int i=0;i<mat.length/2;i++){
            int temp[]= mat[i];
            mat[i]=mat[mat.length-1-i];
            mat[mat.length-1-i]=temp;
        }
        for(int i=0;i<mat.length;i++){
            for(int j=i;j<mat[i].length;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
}