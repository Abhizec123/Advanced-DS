//Spiral Traversal of BT & List of list concept 
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

public class ZigZagTraversal 
{
    static int i=-1;
    public static void main(String args[])
    {
        List<List<Integer>> a=new ArrayList<>();
        //int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        int data[]={1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1};
        Node root = createTree(data);
        
        System.out.print("\nSpiral Traversal is >> ");
        a=spiraltraversal(root);
        for(List i:a)
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
    //Spiral Traversal
    static List<List<Integer>> spiraltraversal(Node root)
    {
        List<List<Integer>> a=new ArrayList<>();
        
        if(root==null)
            return a;

        Queue <Node> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> t=new ArrayList<>();
            int n=q.size();
            for(int j=0;j<n;j++)
            {
                Node cur=q.poll();

                t.add(cur.data);

                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            if(flag)
                Collections.reverse(t);
            
            a.add(t);
            flag=!flag;
        }
        return a;
    }
}
