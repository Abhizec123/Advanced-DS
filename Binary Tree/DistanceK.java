//863. All Nodes Distance K in Binary Tree

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}
public class DistanceK 
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1};
        //int data[]={1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        Node root = createTree(data);
		
        List <Integer> a=new ArrayList<>();
        a=distanceK(root,root,2);
		
        for(int j:a)
            System.out.print(j+" ");
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
    static List<Integer> distanceK(Node root, Node target, int k) 
    {
        Map <Node,Node> par=new HashMap<>();
        Map <Node,Boolean> vis=new HashMap<>();
        Queue <Node> q=new LinkedList<Node>();
        int level=0;

        insparent(root,par);

        q.add(target);
        vis.put(target,true);
        while(!q.isEmpty())
        {
            int s=q.size();
            if(level==k)
                break;
            level++;
            for(int i=0;i<s;i++)
            {
                Node cur=q.poll();

                if(cur.left!=null && vis.get(cur.left)==null)
                {
                    q.add(cur.left);
                    vis.put(cur.left,true);
                }
                if(cur.right!=null && vis.get(cur.right)==null)
                {
                    q.add(cur.right);
                    vis.put(cur.right,true);
                }
                if(par.get(cur)!=null && vis.get(par.get(cur))==null)
                {
                    q.add(par.get(cur));
                    vis.put(par.get(cur),true);
                }
            }
        }
        ArrayList <Integer> a=new ArrayList<>();
        int s=q.size();
        for(int i=0;i<s;i++)
            a.add(q.poll().data);
        
        return a;
        
    }
    static void insparent(Node root, Map <Node,Node> par)
    {
        Queue <Node> q =new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            Node cur=q.poll();

            if(cur.left!=null)
            {
                par.put(cur.left,cur);
                q.add(cur.left);
            }
            if(cur.right!=null)
            {
                par.put(cur.right,cur);
                q.add(cur.right);
            }
        }
    }
}
