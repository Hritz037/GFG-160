class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        int indegree[]=new int[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        while(ans.size()<V){
        for(int i=0;i<V;i++){
            if(indegree[i]==0){q.add(i);indegree[i]--;}
        }
        while(q.size()!=0){
            int x=q.poll();
            // indegree[x]--;
            ans.add(x);
            for(Integer y:adj.get(x))indegree[y]--;
        }
        }
        // System.out.println(ans);
        return ans;
        
    }
}