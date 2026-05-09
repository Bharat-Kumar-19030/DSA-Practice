class Solution {
    void rot(int [][]mat,int sti,int stj,int endi,int endj){
        int temp=mat[sti][stj];
        for(int i=stj;i<endj;i++){
            mat[sti][i]=mat[sti][i+1];
        }
        for(int i=sti;i<endi;i++){
            mat[i][endj]=mat[i+1][endj];
        }
        for(int i=endj;i>stj;i--){
            mat[endi][i]=mat[endi][i-1];
        }
        for(int i=endi;i>sti;i--){
            if(i-1==sti){
                mat[i][stj]=temp;
            }
            else
            mat[i][stj]=mat[i-1][stj];
        }

        // int clen=2*Math.max(0,mat.length-(2*i))+2*Math.max(0,mat[0].length-(2*(j+1)));
    }
    public int[][] rotateGrid(int[][] mat, int k) {
        int left=0,right=mat[0].length-1,down=mat.length-1,top=0;
        while(left<right&&top<down){
            int j=left;
            int i=top;
            int clen=2*Math.max(0,mat.length-(2*i))+2*Math.max(0,mat[0].length-(2*(j+1)));
            int currot=clen==0?0:k%clen;
            if(currot>0){
                for(int p=0;p<currot;p++){
                    rot(mat,i,j,mat.length-i-1,mat[0].length-1-i);
                }
            }
            left++;right--;top++;down--;
        }
        return mat;        
    }
}