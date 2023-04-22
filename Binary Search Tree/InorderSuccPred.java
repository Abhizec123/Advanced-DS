//Finding the inorder successor and predecessor of a node in BST
class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}
public class InorderSuccPred 
{
    public static void main(String args[])
    {
        int data[]={5,3,2,4,7,6,9,8,10};
        Node root=null;
        for(int j=0;j<data.length;j++) 
            root = createTree(root,data[j]);

        int v=7;
        System.out.print("Inorder Successor of "+v+" >> "+findSuccessor(root, v).data);
        System.out.print("\nInorder Predecessor of "+v+" >> "+findPredecessor(root, v).data);
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
    static Node findSuccessor(Node root,int key)
    {
        Node ans=null;

        while(root!=null)
        {
            if(key>=root.data)
                root=root.right;
            else
            {
                ans=root;
                root=root.left;
            }
        }
        return ans;
    }
    static Node findPredecessor(Node root,int key)
    {
        Node ans=null;

        while(root!=null)
        {
            if(key<=root.data)
                root=root.left;
            else
            {  
                ans=root;
                root=root.right;
            }
        }
        return ans;
    }
}
