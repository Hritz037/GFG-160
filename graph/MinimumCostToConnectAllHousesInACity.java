
//points to be noted
//We are trying to find minimum spanning tree here
//This uses priorityqueue
//First just add the first house 
//and the distance between the first house and current which is 0.
//Then poll until the priorityqueue becomes empty
//Then add the distance from the polled house and all the houses that are not visited
//we'll again take the minimum distance and continue till priority queue empties
class Solution {

    public int minCost(int[][] houses) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(0,0));
        int visited[]=new int[houses.length];
        int ans=0;
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            if(visited[top.index]==1)continue;
            ans+=top.dist;visited[top.index]=1;
            for(int i=0;i<houses.length;i++){
                if(visited[i]==0){
                    pq.add(new Pair(Math.abs(houses[top.index][0]-houses[i][0])+
                    Math.abs(houses[top.index][1]-houses[i][1]),i));
                }
            }
        }
        return ans;
    }
}

class Pair{
    Integer dist, index;
    Pair(Integer dist, Integer index){
        this.dist=dist;
        this.index=index;
    }
}