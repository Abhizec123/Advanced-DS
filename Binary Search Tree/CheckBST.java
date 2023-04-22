/*  CHECK FOR A VALID BST
 *  3 2 4 
    Is this a BST >> false
 */
class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}
public class CheckBST 
{
    static int i=-1;
    public static void main(String args[])
    {
        int data[]={2,1,-1,-1,4,-1,-1};
        Node root = createTree(data);

        inOrder(root);
		System.out.println();
		
        System.out.print("Is this a BST >> "+isBST(root));
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
    static boolean isBST(Node root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);    
    }
    static boolean isValidBST(Node root,long min,long max)
    {
        if(root==null)
            return true;
        if(root.data>=max || root.data<=min)
            return false;
        return isValidBST(root.left,min,root.data) && isValidBST(root.right,root.data,max); 
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
