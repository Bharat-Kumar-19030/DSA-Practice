/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Idx{
    int id;
    Idx(int n){
        id=n;
    }
 }
class Solution {
    
    TreeNode check(String str,Idx idx,int prev){
        int count=0;
        int temp=idx.id;
        while(temp<str.length()&&str.charAt(temp)=='-'){count++;temp++;}
        if(count==prev+1){
            int num=0;
            // System.out.println("from: "+temp);
            while(temp<str.length()&&Character.isDigit(str.charAt(temp))){
                // System.out.println(Integer.valueOf(str.charAt(temp)));
                num=num*10+Integer.valueOf(str.charAt(temp))-48;
                temp++;
            }
            // System.out.println("to :"+temp+" "+num);
            TreeNode curr=new TreeNode(num);
            idx.id=temp;
            curr.left=check(str,idx,count);
            curr.right=check(str,idx,count);
            return curr;
        }
        return null;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        Idx idx= new Idx(0);
        return check(traversal,idx,-1);
    }
}