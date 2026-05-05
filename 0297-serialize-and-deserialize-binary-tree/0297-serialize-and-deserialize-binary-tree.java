/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp= q.poll();
            if(temp!=null){
                sb.append(","+String.valueOf(temp.val));
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                sb.append(",null");
            }
        }
        sb.deleteCharAt(0);
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root=null;
        String arr[]= data.split(",");
        // System.out.println(Arrays.toString(arr));
        Queue<TreeNode> q= new LinkedList<>();
        if(arr.length>0)q.offer("null".equals(arr[0])?null:new TreeNode(Integer.valueOf(arr[0])));
        root=q.peek();
        for(int i=1;i<arr.length;i++){
            TreeNode req=q.poll();
            if(req!=null){
                // System.out.println(arr[i]);
                req.left="null".equals(arr[i])?null:new TreeNode(Integer.valueOf(arr[i]));
                if(req.left!=null)q.offer(req.left);
                i++;
                req.right=i>=arr.length||"null".equals(arr[i])?null:new TreeNode(Integer.valueOf(arr[i]));
                if(req.right!=null)q.offer(req.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));