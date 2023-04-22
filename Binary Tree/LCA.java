/* Lowest Common Ancestor of BT
 * 
 *      2
 *     / \
 *    3   4
 *       /
 *      5
 */
import java.util.Scanner;

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}
public class LCA 
{
    static int i=-1,ans=0;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);

        System.out.print("Enter Node-1 : ");
        int a=sc.nextInt();
        System.out.print("Enter Node-2 : ");
        int b=sc.nextInt();

        Node cur=ancestor(root,a,b);
        System.out.print("\nLowest Common Ancestor of a BT >> "+cur.data);
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
    static Node ancestor(Node root,int n1,int n2)
    {
        if(root==null)
            return null;
        
        if(root.data==n1 || root.data==n2)
            return root;

        Node l=ancestor(root.left, n1, n2);
        Node r=ancestor(root.right, n1, n2);

        if(l==null)
            return r;
        if(r==null)
            return l;
        
        return root;
    }
}
