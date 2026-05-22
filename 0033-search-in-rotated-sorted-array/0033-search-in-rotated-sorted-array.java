class Solution {
    public int search(int[] nums, int target) {
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[l]){
                if(nums[mid]>=target&&nums[l]<=target){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<=target&&target<=nums[h]){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna