/*
class Node {
    int data;
    Node left, right,next;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    Node prev=null;
    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            if(prev!=null){
                // System.out.print(prev.data+"->"+root.data+" ");
                prev.next=root;
                prev=root;
            }
            else{
                prev=root;
            }
            inorder(root.right);
        }
    }
    public void populateNext(Node root) {
        // code here
        inorder(root);
        
    }
}