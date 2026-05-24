class Solution {
    int check(int arr[],int d,int idx,int[]memo){
        if(idx<0||idx>arr.length-1){
            return -1;
        }
        if(memo[idx]!=-2)return memo[idx];
        int res=1;
        int max=arr[idx];
        for(int i=1;i<=d;i++){
            if(idx-i>=0&&arr[idx-i]>=max)break;
            int a=check(arr,d,idx-i,memo);
            if(a!=-1){
                res=Math.max(res,a+1);
            }
            
        }
        for(int i=1;i<=d;i++){
            if(idx+i<arr.length&&arr[idx+i]>=max)break;
            int b=check(arr,d,idx+i,memo);
            if(b!=-1){
                res=Math.max(res,b+1);
            }
        }            
        return memo[idx]=res;        
    }
    public int maxJumps(int[] arr, int d) {
        int res=0;
        int []memo=new int[arr.length];
        Arrays.fill(memo,-2);
        for(int i=0;i<arr.length;i++){           
            res=Math.max(res,check(arr,d,i,memo));
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna