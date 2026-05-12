class Solution {
    void check(char mat[][],int i,int j,boolean visited[][]){
        if(i<0||i>=mat.length||j<0||j>=mat[0].length){
            return ;
        }
        if(visited[i][j]||mat[i][j]=='0')return ;
        mat[i][j]='0';
        visited[i][j]=true;
        check(mat,i+1,j,visited);
        check(mat,i-1,j,visited);
        check(mat,i,j+1,visited);
        check(mat,i,j-1,visited);
    }
    public int numIslands(char[][] grid) {
        boolean visited[][]= new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    ans++;
                    check(grid,i,j,visited);
                }
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna