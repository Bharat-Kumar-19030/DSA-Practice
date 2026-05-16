class Solution {
    int ans=Integer.MAX_VALUE;
    void check(int nums[],int l,int h){
        if(l>h)return;
        int mid=l+(h-l)/2;
        if(nums[mid]==nums[l]){
            ans=Math.min(ans,nums[l]);
            check(nums,mid+1,h);
            check(nums,l,mid-1);
        }else if(nums[mid]==nums[h]){
            ans=Math.min(nums[mid],ans);
            check(nums,l,mid-1);
            check(nums,mid+1,h);
        }
        else if(nums[mid]>nums[l]){
            ans=Math.min(ans,nums[l]);
            check(nums,mid+1,h);
        }
        else{
            ans=Math.min(ans,nums[mid]);
            check(nums,l,mid-1);
        }
    }
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1])return nums[0];
        check(nums,0,nums.length-1);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna