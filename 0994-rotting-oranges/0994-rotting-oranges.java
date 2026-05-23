class Solution {
    public int orangesRotting(int[][] grid) {
        boolean visited[][]= new boolean[grid.length][grid[0].length];
        Queue<int[]>q= new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int count=-1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int k=0;k<s;k++){
                int arr[]= q.poll();
                int i=arr[0];
                int j=arr[1];
                if(i-1>=0&&!visited[i-1][j]&&grid[i-1][j]==1){
                    q.offer(new int[]{i-1,j});
                    grid[i-1][j]=2;
                    visited[i-1][j]=true;
                }
                if(i+1<grid.length&&!visited[i+1][j]&&grid[i+1][j]==1){
                    q.offer(new int[]{i+1,j});
                    grid[i+1][j]=2;
                    visited[i+1][j]=true;
                }
                if(j-1>=0&&!visited[i][j-1]&&grid[i][j-1]==1){
                    q.offer(new int[]{i,j-1});
                    grid[i][j-1]=2;
                    visited[i][j-1]=true;
                }
                if(j+1<grid[0].length&&!visited[i][j+1]&&grid[i][j+1]==1){
                    q.offer(new int[]{i,j+1});
                    grid[i][j+1]=2;
                    visited[i][j+1]=true;
                }
            }
            count++;            
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count==-1?0:count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna