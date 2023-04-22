//Level-Order Traversal (2 Methods)

import java.util.LinkedList;
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

public class LevelOrder 
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);
		
        System.out.print("The Inorder Traversal is >> ");
        inOrder(root);
		System.out.println();
        int h=height(root);
        System.out.print("The Height is >> "+h);

        System.out.print("\nThe Level-Order Traversal is >> ");
        for(int j=1;j<=h;j++)
            bfstraversal(root, j);
        
        System.out.print("\nThe Level-Order Traversal(Optimized) is >> ");
        bfstraversal2(root);
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
    static int height(Node root)
    {
        if(root==null)
            return 0;
        else
            return height(root.left)+height(root.right)+1;
    }
    //Method-1 Complexity - O(N^2)
    static void bfstraversal(Node root,int level)
    {
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.data+" ");
        else if(level>1)
        {
            bfstraversal(root.left, level-1);
            bfstraversal(root.right, level-1);
        }
    }
    //Method-2 Using Queue Complexity - O(N)
    static void bfstraversal2(Node root)
    {
        Queue <Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node cur=q.poll();
            System.out.print(cur.data+" ");
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
    }
}

/* Home Assignment : if we want to print the level-order in level wise 
    for Ex: 2
            3 4
            5
            what changes we have to do?
    Hint:   Add Null value, whenever null is detected print new line
*/