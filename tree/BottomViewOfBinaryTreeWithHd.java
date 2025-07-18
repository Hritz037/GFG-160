//question link- https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public void traverse(Node root, int vlevel, TreeMap<Integer,Pair> treeMap){
        if(root==null)return;
        // System.out.println(root.hd);
        if(!treeMap.containsKey(root.hd))
        treeMap.put(root.hd,new Pair(root.data,vlevel));
        else {
            if(treeMap.get(root.hd).vlevel<=vlevel){
                treeMap.put(root.hd, new Pair(root.data,vlevel));
            }
        }
        if(root.left!=null)root.left.hd=root.hd-1;
        if(root.right!=null)root.right.hd=root.hd+1;
        traverse(root.left,vlevel+1,treeMap);
        traverse(root.right,vlevel+1,treeMap);
    }
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer,Pair> treeMap=new TreeMap<>();
        root.hd=0;
        traverse(root,0,treeMap);
        ArrayList<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Pair> e:treeMap.entrySet()){
            ans.add(e.getValue().val);
        }
        return ans;
    }
    //make sure to consider both the vertical as well as horizontal level,
    //here hd has been given so we will make use of this as well
}
class Pair{
    int val,vlevel;
    Pair(int val, int vlevel){
        this.val=val;
        this.vlevel=vlevel;
    }
}    
