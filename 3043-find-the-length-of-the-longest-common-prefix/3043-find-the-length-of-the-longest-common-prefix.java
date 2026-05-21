class tri{
    int val;
    tri child[]= new tri[10];
    tri(int v){
        val=v;
    }
    boolean isend=false;
}
class Solution {
    int add(tri root,int val){
        tri curr=root;
        Stack<Integer> st= new Stack<>();
        while(val>0){
            st.push(val%10);
            val/=10;
        }
        int count=0;
        boolean found=false;
        while(!st.isEmpty()){
            if(curr.child[st.peek()]!=null&&!found)count++;
            else {curr.child[st.peek()]= new tri(st.peek());found=true;}
            curr=curr.child[st.peek()];
            if(st.size()==1){
                curr.isend=true;
            }
            st.pop();
        }
        return count;
    }
    int find(tri root, int val){
    tri curr = root;
    Stack<Integer> st = new Stack<>();
    while(val > 0){
        st.push(val % 10);
        val /= 10;
    }
    
    int count = 0;
    while(!st.isEmpty()){
        int digit = st.pop(); // Pop it immediately so the loop moves forward
        
        if(curr.child[digit] != null){
            count++;
            curr = curr.child[digit];
        } else {
            break; // No match found, stop looking
        }
    }
    return count;
}
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans=0;
        tri root= new tri(-1);
        for(int i:arr1){
            add(root,i);
        }
        for(int i:arr2){
            ans=Math.max(ans,find(root,i));
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna