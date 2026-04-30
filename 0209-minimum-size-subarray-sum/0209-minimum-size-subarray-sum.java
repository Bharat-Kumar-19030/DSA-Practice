class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int ans=nums.length+1;
        int st=0;
        for(int i=0;i<nums.length;i++){
            while(st<=i&&sum>=target){
                ans=Math.min(ans,i-st);
                sum-=nums[st];
                st++;
            }
            sum+=nums[i];
        }
        while(st<nums.length&&sum>=target){
            ans=Math.min(ans,nums.length-st);
            sum-=nums[st];
            st++;
        }
        return ans==nums.length+1?0:ans;
    }
}