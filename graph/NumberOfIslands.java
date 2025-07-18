//Problem link- https://www.geeksforgeeks.org/batch/gfg-160-problems/track/graph-gfg-160/problem/find-the-number-of-islands
class Solution {
    public int countIslands(char[][] grid) {
        int ans=0, visited[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                Queue<Integer> q=new LinkedList<>();
                if(grid[i][j]=='L' && visited[i][j]==0){
                    q.add(grid[0].length*i+j);
                    while(!q.isEmpty()){
                        int x=q.poll();
                        int m=x/grid[0].length;
                        int n=x%grid[0].length;
                        if(visited[m][n]==1)continue;
                        //above is necessary because even though you are not adding any vertex that's visited
                        //it may get visited after being added to queue.
                        visited[m][n]=1;
                        //do it this way instead of having array of r and c and then checking whether its safe
                        //just copy paste the above condition to save time
                        if(m>0 && visited[m-1][n]==0 && grid[m-1][n]=='L'){
                            q.add((m-1)*grid[0].length+n);
                        } 
                        if(m<grid.length-1 && visited[m+1][n]==0 && grid[m+1][n]=='L'){
                            q.add((m+1)*grid[0].length +n);
                        }
                        if(n>0 && visited[m][n-1]==0 && grid[m][n-1]=='L'){
                            q.add(m*grid[0].length + n-1);
                        }
                        if(n<grid[0].length-1 && visited[m][n+1]==0 && grid[m][n+1]=='L'){
                            q.add(m*grid[0].length +n+1);
                        }
                        if(m>0 && n>0 && visited[m-1][n-1]==0 && grid[m-1][n-1]=='L' ){
                            q.add((m-1)*grid[0].length +n-1);
                        }
                        if(m>0 && n<grid[0].length-1 && visited[m-1][n+1]==0 && grid[m-1][n+1]=='L'){
                            q.add((m-1)*grid[0].length+n+1);
                        }
                        if(m<grid.length-1 && n>0 && visited[m+1][n-1]==0 && grid[m+1][n-1]=='L'){
                            q.add((m+1)*grid[0].length+n-1);
                        }
                        if(m<grid.length-1 && n<grid[0].length-1 && visited[m+1][n+1]==0 && grid[m+1][n+1]=='L'){
                            q.add((m+1)*grid[0].length+n+1);
                        }
                    }
                    ans++;
                }
            }
        }return ans;
        
    }
}
