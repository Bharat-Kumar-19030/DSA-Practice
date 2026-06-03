class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                nums[i]=-1;
        }
        HashMap<Integer,Integer> map= new HashMap<>();
        int ans=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==0){
                ans=Math.max(ans,i+1);
                map.put(sum,i);
            }
            else if(map.containsKey(sum)){
                ans=Math.max(ans,i-map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna