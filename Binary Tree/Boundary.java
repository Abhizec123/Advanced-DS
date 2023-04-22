/* Anti-Clockwise Boundary Traversal

 *         1
 *        / \
 *       2    5
 *      / \   /
 *     3   4 6
 *          /
 *         7
 */

import java.util.ArrayList;
import java.util.Collections;

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}

public class Boundary 
{
    static int i=-1;
    public static void main(String args[])
    {
        ArrayList <Integer> a=new ArrayList<>();
        //int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        int data[]={1,2,3,-1,-1,4,-1,-1,5,6,7,-1,-1,-1,-1};
        //int data[]={1,-1,-1};
        Node root = createTree(data);
        
        System.out.print("\nBoundary Traversal is >> ");
        boundarytrav(root,a);

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
    static void boundarytrav(Node root, ArrayList<Integer> a)
    {
        if(isLeaf(root)==false)
            a.add(root.data);
        
        addleftboundary(root, a);
        addleaves(root, a);
        addrightboundary(root, a);
    }
    static void addleftboundary(Node root, ArrayList<Integer> a)
    {
        Node cur=root.left;
        while(cur!=null)
        {
            if(isLeaf(cur)==false)
                a.add(cur.data);
            if(cur.left!=null)
                cur=cur.left;
            else
                cur=cur.right;
        }
    }
    static void addleaves(Node root,ArrayList<Integer> a)
    {
        if(isLeaf(root))
        {
            a.add(root.data);
            return;
        }

        if(root.left!=null)
            addleaves(root.left, a);
        if(root.right!=null)
            addleaves(root.right, a);            
    }  
    static void addrightboundary(Node root, ArrayList<Integer> a)
    {
        ArrayList <Integer> t=new ArrayList<>();

        Node cur=root.right;
        while(cur!=null)
        {
            if(isLeaf(cur)==false)
                t.add(cur.data);
            if(cur.right!=null)
                cur=cur.right;
            else
                cur=cur.left;
        }
        Collections.reverse(t);
        for(int j:t)
            a.add(j);
    } 
    static boolean isLeaf(Node root)
    {
        if(root.left == null && root.right==null)
            return true;
        else
            return false;
    }
}
