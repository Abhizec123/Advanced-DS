//Binary Tree Insertion (Method 2)

class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}

public class BT02 
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,-1,-1};
        Node root = createTree(data);
		
        inOrder(root);
		System.out.println();

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
}
