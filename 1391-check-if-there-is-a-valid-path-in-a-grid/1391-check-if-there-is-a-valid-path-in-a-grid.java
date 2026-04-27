class Solution {
    char[] stdir(int grid[][],int x,int y){
        switch (grid[x][y]){
            case 1:
            return new char[]{'l','r'};
            case 3:
            return new char[]{'l','d'};
            case 5:
            return new char[]{'l','u'}; // st= left;
            case 2:
            return new char[]{'u','d'};
            case 4:
            return new char[]{'r','d'};
            case 6:
            return new char[]{'r','u'}; //st=right;
        }
        return new char[]{'a','a'};
    }
    int enddir(int grid[][],int x,int y){
        switch (grid[x][y]){
            case 1:
            return 2; // end= right;
            case 2:
            case 3:
            case 4:
            return 3; //end= down;
            case 5:
            case 6:
            return 1; //end=top;
        }
        return -1;
    }
    boolean check(int grid[][],int x,int y,char prev,boolean visited[][]){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return false;
        }
        if(visited[x][y])return false;
        visited[x][y]=true;
        // if(prev!='a'){
            char [] op=stdir(grid,x,y);
            // System.out.println("at: "+x+" "+y+" "+Arrays.toString(op)+" "+prev);
            char g='a';
            if(op[0]==prev){
                g=op[1];
            }
            else if(op[1]==prev){
                g=op[0];
            }else return false;
            if(x==grid.length-1&&y==grid[0].length-1)return true;
            if(g=='l'){
                return check(grid,x,y-1,'r',visited);
            }
            else if(g=='r'){
                return check(grid,x,y+1,'l',visited);
            }
            else if(g=='u'){
                return check(grid,x-1,y,'d',visited);
            }
            else if(g=='d'){
                return check(grid,x+1,y,'u',visited);
            }
        // }
        return false;

    }
    public boolean hasValidPath(int[][] grid) {
        boolean visited[][]= new boolean[grid.length][grid[0].length];
        char op[]= stdir(grid,0,0);
        // System.out.println(Arrays.toString(op));
        boolean a=check(grid,0,0,op[0],visited);
        visited=new boolean[grid.length][grid[0].length];
        return a||check(grid,0,0,op[1],visited);
    }
}