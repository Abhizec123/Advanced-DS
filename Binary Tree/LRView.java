//Left & Right View of a BT (Striver's Understanding)

import java.util.ArrayList;

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}

public class LRView
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);
		
        System.out.print("The Inorder Traversal is >> ");
        inOrder(root);
		System.out.println();
        
        printview(root);
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
    static void inOrder(Node root) 
    {
		if(root == null) 
            return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
    static void printview(Node root)
    {
        ArrayList <Node> list01=new ArrayList<>();
        leftview(root,list01,0);

        System.out.print("\nThe Left-View of BT is >> ");
        for(Node cur:list01)
            System.out.print(cur.data+" ");

        ArrayList <Node> list02=new ArrayList<>();
        rightview(root,list02,0);

        System.out.print("\nThe Right-View of BT is >> ");
        for(Node cur:list02)
            System.out.print(cur.data+" ");
    } 
    static void leftview(Node root,ArrayList <Node> list,int level)
    {
        if(root==null)
            return;

        if(list.size()==level)
            list.add(level,root);
        
        leftview(root.left,list,level+1);
        leftview(root.right,list,level+1);
    }
    static void rightview(Node root,ArrayList <Node> list,int level)
    {
        if(root==null)
            return;

        if(list.size()==level)
            list.add(level,root);
            
        leftview(root.right,list,level+1);
        leftview(root.left,list,level+1);
    }
}