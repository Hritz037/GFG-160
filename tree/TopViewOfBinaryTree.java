//Question link: https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
static void traverse(Node root, int level, int vlevel, TreeMap<Integer,Pair> treeMap){
    if(root==null)return;
    if(treeMap.containsKey(level)){
        if(treeMap.get(level).vlevel>vlevel){
            //remember to compare vlevel to vlevel
            //Always remember no equal to if the first came,
            // then it should stay
            treeMap.put(level,new Pair(root.data,vlevel));
        }
    }else treeMap.put(level, new Pair(root.data,vlevel));
    traverse(root.left,level-1,vlevel+1,treeMap);
    traverse(root.right,level+1,vlevel+1,treeMap);
}

    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Pair> treeMap=new TreeMap<>();
        traverse(root,0,0,treeMap);
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Pair> e: treeMap.entrySet()){
            ans.add(e.getValue().val);
        }
        return ans;
    }
}
class Pair{
    Integer val, vlevel;
    Pair(int val, int vlevel){
        this.val=val;
        this.vlevel=vlevel;
    }
}            //remember to compare vlevel to vlevel

