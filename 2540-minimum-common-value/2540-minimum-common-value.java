class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i:nums2){
            if(set.contains(i)){
                ans=Math.min(ans,i);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna