/*  Balanced Binary Tree - A height-balanced binary tree is a binary tree 
    in which the depth of the two subtrees of every node never differs 
    by more than one.

    Same Tree - Two binary trees are considered the same if they are 
    structurally identical, and the nodes have the same value.

    Symmetric Tree - check whether it is a mirror of itself 
    (i.e., symmetric around its center).

 *      2
 *     / \
 *    3   4
 *       /
 *      5
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
public class Check 
{
    static int i=-1,ans=0;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1}; 
        Node root = createTree(data);

        boolean b=isBalanced(root);
        System.out.print("\nBalanced Tree >> "+b);

        boolean b1=isSameTree(root,root);
        System.out.print("\nSame Tree >> "+b1);

        boolean b2=isSymmetric(root);
        System.out.print("\nSymmetric Tree >> "+b2);
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
    //Balance Checking
    static boolean isBalanced(Node root) 
    {
        int l=height(root);
        
        if(l==-1)
            return false;
        else 
            return true;
    }
    static int height(Node root)
    {
        if(root==null)
            return 0;
        
        int l=height(root.left);
        if(l==-1)
            return -1;
        int r=height(root.right);
        if(r==-1)
            return -1;

        if (Math.abs(l-r)>1)
            return -1;

        return Math.max(l,r)+1;
    }
    //Similar Checking
    static boolean isSameTree(Node p, Node q) 
    {
        if(p==null || q==null)
            return (p==q);
        
        return (p.data==q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    //Symmetric Checking
    static boolean isSymmetric(Node root) 
    {
        return root==null || isSym(root.left,root.right);
    }
    static boolean isSym(Node leftN,Node rightN)
    {
        if(leftN==null || rightN==null)
            return (leftN==rightN);
        
        if(leftN.data!=rightN.data)
            return false;
        
        return isSym(leftN.left,rightN.right) && isSym(leftN.right,rightN.left);
    }
}
