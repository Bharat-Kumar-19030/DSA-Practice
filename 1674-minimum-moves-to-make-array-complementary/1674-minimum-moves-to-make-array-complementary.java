class Solution {
    public int minMoves(int[] nums, int limit) {
        int diff[]= new int[2*limit+2];
        // Arrays.fill(diff,2);
        for(int i=0;i<nums.length/2;i++){
            int min=nums[i]<nums[nums.length-1-i]?nums[i]:nums[nums.length-1-i];
            int max=nums[i]>nums[nums.length-1-i]?nums[i]:nums[nums.length-1-i];
            int lower=min+1;
            int higher=max+limit;
            diff[2]+=2;
            diff[2*limit+1]-=2;
            diff[lower]+=(-1);
            diff[higher+1]-=(-1);
            diff[nums[i]+nums[nums.length-1-i]]+=(-1);
            diff[nums[i]+nums[nums.length-1-i]+1]-=(-1);
        }
        int ans=Integer.MAX_VALUE;
        // System.out.println(Arrays.toString(diff));
        for(int i=2;i<2*limit;i++){
            diff[i]=diff[i-1]+diff[i];
            ans=Math.min(ans,diff[i]);
        }
        return ans==Integer.MAX_VALUE?0:ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna