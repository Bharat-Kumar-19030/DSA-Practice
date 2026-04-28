/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int count=0;
    int ans=-1;
    void check(Node root,int k){
        if(root!=null){
            if(count>k)return ;
            check(root.left,k);
            count++;
            if(count==k)ans=root.data;
            check(root.right,k);
            // count++;
            
        }
    }
    public int kthSmallest(Node root, int k) {
        check(root,k);
        return ans;
        // code here
        
    }
}