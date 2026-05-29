class Solution {
    int sum(int n){
        int ret=0;
        while(n>0){
            ret+=n%10;
            n/=10;
        }
        return ret;
    }
    public int minElement(int[] nums) {
        int ans=nums[0];
        for(int i:nums){
            ans=Math.min(ans,sum(i));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna