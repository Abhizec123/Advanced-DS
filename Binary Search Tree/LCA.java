//LCA in BST Using Iterative approach
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
    public static void main(String args[])
    {
        int data[]={20,10,30,25,40};
        Node root=null;
        for(int j=0;j<data.length;j++) 
            root = createTree(root,data[j]);

        root=lowestCommonAncestor(root,root,root);
        System.out.print("LCA is >> "+root.data);
    }
    //Insertion(Recursive Approach) : Time Complexity - O(Log(n))
    static Node createTree(Node root,int data) 
    {
        if(root==null)
            return new Node(data);
        
        if(root.data>data)
            root.left=createTree(root.left,data);
        else if(root.data<data)
            root.right=createTree(root.right,data);
        
        return root;
	}
    static Node lowestCommonAncestor(Node root, Node p, Node q) 
    {
        while(root!=null)
        {
            if(root.data>p.data && root.data>q.data)
                root=root.left;
            else if(root.data<p.data && root.data<q.data)
                root=root.right;
            else 
                return root;
        }
        return null;
    }   
}
