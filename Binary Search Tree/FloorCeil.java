/*  Floor-Ceil in BST:- (Space is not Optimized)
    10 20 25 30 40 
    FLOOR of 12 >> 10
    CEIL of 12 >> 20
 */

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
public class FloorCeil 
{
    public static void main(String args[])
    {
        int data[]={20,10,30,25,40};
        Node root=null;
        for(int j=0;j<data.length;j++) 
            root = createTree(root,data[j]);

        find(root, 35);
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
    static void find(Node root,int key)
    {
        ArrayList <Integer> a=new ArrayList<>();
        a=inOrder(root,a);

        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)>key)
            {
                System.out.print("\nFLOOR of "+key+" >> "+a.get(i-1));
                System.out.print("\nCEIL of "+key+" >> "+a.get(i));
                break;
            }
        }
    }
    static  ArrayList<Integer> inOrder(Node root,ArrayList<Integer> a)
    {
        if(root==null)
            return a;

        inOrder(root.left,a);
        a.add(root.data);
        System.out.print(root.data+" ");
        inOrder(root.right,a);

        return a;
    }
}
