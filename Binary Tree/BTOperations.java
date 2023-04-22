//Height of a Binary Tree
//Size/No of Nodes
//Largest Value

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}
public class BTOperations
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
        int s=height(root);
        System.out.print("\nThe Size/No of Nodes is >> "+s);
        int l=Maximum(root);
        System.out.print("\nThe Largest Number is >> "+l);
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
            return Math.max(height(root.left),height(root.right))+1;
        
    }
    static int size(Node root)
    {
        if(root==null)
            return 0;
        else
            return size(root.left)+size(root.right)+1;
    }
    static int Maximum(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.data,Math.max(Maximum(root.left),Maximum(root.right)));
    }
}
