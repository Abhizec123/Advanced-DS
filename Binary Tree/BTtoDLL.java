/* BT to Doubly Linked List (inOrder traversal)
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

public class BTtoDLL 
{
    static int i=-1;
    static Node prev=null,head=null;
    public static void main(String args[])
    {
        int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        Node root = createTree(data);

        convertToDLL(root);
        System.out.print("BT to DLL (inOrder) >> ");
        display(head);
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
    
    static void convertToDLL(Node root)
    {        
        if(root==null)
            return;
        
        convertToDLL(root.left);

        if(head==null)
            head=prev=root;
        else
        {
            root.left=prev;
            prev.right=root;
            prev=root;
        }
        
        convertToDLL(root.right);
    }
    static void display(Node cur)
    {
        while(cur!=null)
        {
            System.out.print(cur.data+" ");
            cur=cur.right;
        }
    }
}
