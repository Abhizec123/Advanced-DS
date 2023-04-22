//ITERATIVE TRAVERSAL - Pre, In and PostOrder

import java.util.ArrayList;
import java.util.Stack;

class Node
{
    Node left,right;
    int data;

    public Node(int data)
    {
        this.data=data;
    }
}

public class IterativeTraversal 
{
    static int i=-1;
    public static void main(String args[])
    {
        ArrayList <Integer> a=new ArrayList<>();
        ArrayList <Integer> b=new ArrayList<>();
        ArrayList <Integer> c=new ArrayList<>();

        //int data[]={2,3,-1,-1,4,5,-1,-1,-1};
        int data[]={1,2,3,-1,-1,4,-1,-1,5,6,7,-1,-1,-1,-1};
        //int data[]={1,-1,-1};
        Node root = createTree(data);
        
        System.out.print("\nPreOrder Traversal is >> ");
        a=preOrder(root);
        for(int j:a)
            System.out.print(j+" ");

        System.out.print("\nInOrder Traversal is >> ");
        b=inOrder(root);
        for(int j:b)
            System.out.print(j+" ");

        System.out.print("\nPreOrder Traversal(Using 2 Stack) is >> ");
        c=postOrder(root);
        for(int j:c)
            System.out.print(j+" ");
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
    static ArrayList<Integer> preOrder(Node root)
    {
        ArrayList <Integer> a=new ArrayList<>();
        Stack <Node> s=new Stack<>();

        if(root==null)
            return a;
        s.push(root);

        while(!s.empty())
        {
            root=s.pop();
            a.add(root.data);

            if(root.right!=null)
                s.push(root.right);
            if(root.left!=null)
                s.push(root.left);
        }
        return a;
    }
    static ArrayList<Integer> inOrder(Node root)
    {
        ArrayList <Integer> a=new ArrayList<>();
        Stack <Node> s=new Stack<>();

        while(true)
        {
            if(root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else
            {
                if(s.isEmpty())
                    break;

                root=s.pop();
                a.add(root.data);
                root=root.right;
            }
        }
        return a;
    }
    static ArrayList<Integer> postOrder(Node root)
    {
        ArrayList <Integer> a=new ArrayList<>();
        Stack <Node> s1=new Stack<>();
        Stack <Node> s2=new Stack<>();

        if(root==null)
            return a;
        s1.push(root);

        while(!s1.empty())
        {
            root=s1.pop();
            s2.push(root);
            
            if(root.left!=null)
                s1.push(root.left);
            if(root.right!=null)
                s1.push(root.right);
        }
        while(!s2.isEmpty())
            a.add(s2.pop().data);

        return a;
    }
}