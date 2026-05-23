class Solution {
    public boolean check(int[] nums) {
        int b=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                b++;
            }
        }
        if(b==0)return true;
        if(b==1&&nums[nums.length-1]<=nums[0])return true;
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna