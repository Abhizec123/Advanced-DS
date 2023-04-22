/*
 * INSERT-SEARCH-DELETE Operations
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
class BST01
{
    public static void main(String args[])
    {
        int data[]={20,10,30,25,40};
        Node root=null;
        for(int j=0;j<data.length;j++) 
            root = createTree(root,data[j]);
		
        int v=20;
        root=deleteNode(root, v);
        System.out.print("VALUE "+v+" is deleted.\n");

        inOrder(root);
		System.out.println();

        v=25;
        System.out.print("VALUE "+v+" is present >> "+search(root,v));
    }
    //Insertion(Recursive Approach) : Time Complexity - O(Log(n))
    static Node createTree(Node root,int val) 
    {
        if(root==null)
            return new Node(val);
        
        if(root.data>val)
            root.left=createTree(root.left,val);
        else if(root.data<val)
            root.right=createTree(root.right,val);
        
        return root;
	}
    //Insertion(Iterative Approach)
    static Node insert(Node root,int val)
    {
        Node nwnd=new Node(val);
        Node cur=root;
        Node par=null;

        while(cur!=null)
        {
            par=cur;
            if(val>cur.data)
                cur=cur.right;
            else if(val<cur.data)
                cur=cur.left;
        }

        if(par==null)
            return nwnd;
        
        if(val>par.data)
            par.right=nwnd;
        else
            par.left=nwnd;
        
        return root;
    }
    //Search : Time Complexity - O(Log(n))
    static boolean search(Node root,int x)
    {
        if(root==null)
            return false;
        
        if(root.data==x)
            return true;
        
        if(x>root.data)
            return search(root.right,x);
        else
            return search(root.left,x);
    }
    //Deletion : Time Complexity - O(Log(n))
    static Node deleteNode(Node root,int key)
    {
        if(root==null)
            return root;
        
        if(key<root.data)
            root.left=deleteNode(root.left, key);
        else if(key>root.data)
            root.right=deleteNode(root.right, key);
        else
        {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.data=minValue(root.right);

            root.right=deleteNode(root.right, root.data);
        }
        return root;
    }
    static int minValue(Node root)
    {
        int minv=root.data;
        while(root.left!=null)
        {
            minv=root.left.data;
            root=root.left;
        }
        return minv;
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