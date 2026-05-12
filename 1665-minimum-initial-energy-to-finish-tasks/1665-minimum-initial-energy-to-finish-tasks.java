class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->b[1]-b[0]==a[1]-a[0]?b[1]-a[1]:(b[1]-b[0])-(a[1]-a[0]));
        // System.out.println(Arrays.toString(tasks));
        int ans=0;
        int curr=0;
        for(int i=0;i<tasks.length;i++){
            if(curr<=tasks[i][1]){
                ans+=tasks[i][1]-curr;
                curr=tasks[i][1]-tasks[i][0];
            }else{
                curr-=tasks[i][0];
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna