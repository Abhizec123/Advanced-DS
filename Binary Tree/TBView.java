//Top & Bottom View of a BT

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}

public class TBView
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);
		 
        ArrayList<Integer> a=new ArrayList<>();
        a=topview(root);
        
        System.out.print("The Top-View of BT is >> ");
        for(int i:a)
            System.out.print(i+" ");
    } 

    static Node createTree(int data[]) 
    {
		Node root = null;
		
		if(data[++i] == -1) 
            return null;

		root = new Node(data[i]);
		root.left = createTree(data);
		root.right = createTree(data);
		
		return root;
	}
    
    static class Pair 
    {
        Node node;
        int hd;
     
        Pair(Node node, int hd) 
        {
            this.node = node;
            this.hd = hd;
        }
    }
    
    static ArrayList<Integer> topview(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> a=new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) 
        {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if (!map.containsKey(hd)) //FOR BOTTOM VIEW REMOVE THIS LINE
                map.put(hd, curr.data);

            if (curr.left != null) 
                q.add(new Pair(curr.left, hd - 1));
    
            if (curr.right != null) 
                q.add(new Pair(curr.right, hd + 1));
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
            a.add(entry.getValue());
    
        return a;
    }  
}
