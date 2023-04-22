import java.util.ArrayList;

class Node
{
    Node left,right;
    int data;
    
    public Node(int data)
    {
        this.data=data;
    }
}
public class TwoSum
{
    public static void main(String args[])
    {
        int data[]={20,10,30,25,40};
        Node root=null;
        for(int j=0;j<data.length;j++) 
            root = createTree(root,data[j]);

        int v=40;
        System.out.print("2-Sum is present for "+v+" >> "+findTarget(root,v));
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
    //Not optimal Solution coz we can reduce the space complexity further
    static boolean findTarget(Node root, int k) 
    {
        ArrayList <Integer> a=new ArrayList<>();
        a=inOrder(root,a);

        int head=0;
        int tail=a.size()-1;
        while(head!=tail)
        {
            if(a.get(head)+a.get(tail)>k)
                tail--;
            else if(a.get(head)+a.get(tail)<k)
                head++;
            else
                return true;
        }
        return false;
    }
    static  ArrayList<Integer> inOrder(Node root,ArrayList<Integer> a)
    {
        if(root==null)
            return a;

        inOrder(root.left,a);
        a.add(root.data);
        inOrder(root.right,a);

        return a;
    }
}
