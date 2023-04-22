/* Diameter of BT
 * 
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
public class Diameter 
{
    static int i=-1,ans=0;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);

        int i=DiameterBT(root);
        System.out.print("Diameter of a BT >> "+ans);
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
    
    static int DiameterBT(Node root)
    {     
        if(root==null)
            return 0;
        
        int lh=DiameterBT(root.left);   
        int rh=DiameterBT(root.right);
        ans=Math.max(ans+1,lh+rh);
        
        return 1+Math.max(lh,rh);
    }
}
