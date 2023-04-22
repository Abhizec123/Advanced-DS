//Count Complete Tree Nodes - every level, except possibly the last, 
//is completely filled in a complete binary tree, and all nodes in 
//the last level are as far left as possible.

class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}

public class totalnodes
{
    static int i=-1;
    public static void main(String args[])
    {
        //int data[]={1,2,3,-1,-1,4,-1,-1,5,6,-1,-1,-1};
        int data[]={1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        Node root = createTree(data);
		
        int c=totalnode(root);
		System.out.println("Total No of Nodes >> "+c);

        int c1=totalnodeoptm(root);
		System.out.println("Total No of Nodes in Complete BT (Optimized) >> "+c1);
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
    //Time Complexity - O(N)
    static int totalnode(Node root)
    {
        if(root==null)
            return 0;

        return totalnode(root.left)+totalnode(root.right)+1;
    }
    //total no of of nodes in a complete binary tree 
    //with lesser than O(N) complexity
    //Time Complexity - O(Log N * Log N)
    static int totalnodeoptm(Node root)
    {
        if(root==null)
            return 0;
        
        int lh=leftheight(root);
        int rh=rightheight(root);

        if(lh==rh)
            return (int)Math.pow(2,lh)-1;
        else
            return totalnodeoptm(root.left)+totalnodeoptm(root.right)+1;
    }
    static int leftheight(Node root)
    {
        int c=0;
        while(root!=null)
        {
            c++;
            root=root.left;
        }
        return c;
    }
    static int rightheight(Node root)
    {
        int c=0;
        while(root!=null)
        {
            c++;
            root=root.right;
        }
        return c;
    }
}
