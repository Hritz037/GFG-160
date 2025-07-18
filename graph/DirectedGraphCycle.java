question link: https://www.geeksforgeeks.org/batch/gfg-160-problems/track/graph-gfg-160/problem/detect-cycle-in-a-directed-graph
class Solution {
    public boolean dfs(int V,int[] visited, HashSet<Integer> inLoop, ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.get(V).size();i++){
            int x=adj.get(V).get(i);
            if(inLoop.contains(x))return true;
            if(visited[x]==1)continue;
            visited[x]=1;
            inLoop.add(x);
            if(dfs(x,visited,inLoop,adj)==true)return true;
            inLoop.remove(x);
        }return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // Stack<Integer> s=new Stack<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int visited[]=new int[V];
        for(int x=0;x<V;x++){
            if(visited[x]==0){
                visited[x]=1;
                HashSet<Integer> inLoop=new HashSet<>();
                inLoop.add(x);
                if(dfs(x,visited,inLoop,adj)==true)return true;
                
            }
        }
        return false;
    }
}