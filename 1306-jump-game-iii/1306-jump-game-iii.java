class Solution {
    boolean check(int arr[],int idx,int memo[],boolean visited[]){
        if(idx<0||idx>=arr.length)return false;
        if(arr[idx]==0)return true;
        if(memo[idx]!=-1)return memo[idx]==0?false:true;
        // System.out.println("at idx: "+idx);
        if(!visited[idx]){
            // System.out.println("not visited");
            visited[idx]=true;
            boolean ans= check(arr,idx+arr[idx],memo,visited)||check(arr,idx-arr[idx],memo,visited);
            memo[idx]=ans?1:0;  
            return ans;   
        }
        return false;           
    }
    public boolean canReach(int[] arr, int start) {
        int memo[]= new int[arr.length];
        Arrays.fill(memo,-1);
        boolean visited[]= new boolean[arr.length];
        return check(arr,start,memo,visited);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna