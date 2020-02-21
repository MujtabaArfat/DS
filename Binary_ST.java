public class Binary_ST{
    public class IntNode{
        public int val;
        public IntNode parent,left,right;

        public IntNode(int v, IntNode l,IntNode r,IntNode p){
            this.val = v;
            this.left= l;
            this.right = r;
           this.parent=p;
        }
    }
    public IntNode root;
    public int[] inord_arr;
    public Binary_ST(int val){
        root = new IntNode(val,null,null,null);
       inord_arr= new int[100];
    }
    private IntNode insertNode(IntNode t, int val){
        if(t==null)
            t= new IntNode(val,null,null,null);
        else if(t.val>=val)
            t.left= insertNode(t.left,val);
        else
            t.right= insertNode(t.right,val);
        return t;
           
        }
   public void insertNode(int val){
           if(root.val<=val)
              root.right=insertNode(root.right,val);
           else
              root.left=insertNode(root.left,val);
           
        
   }
   private void inorder(IntNode t){
        if(t==null)
           return;
      else{
            inorder(t.left);
            System.out.println(t.val);
            inorder(t.right);
      }
   }
   
   public void inorder(){
      if(root==null)
         System.out.println("Cannot perform inorder traversal as list is empty");
      else
         inorder(root);
         
   }

   public IntNode getPredecessor(IntNode delete_node){
    IntNode predecessor =null;
    IntNode predecessorparent =null;
    IntNode current = delete_node.left;
    while(current!=null){
        predecessorparent = predecessor;
        predecessor = current;
        current = current.right;
    }
    //check if successor has the right child, it cannot have left child for sure
    // if it does have the right child, add it to the left of successorParent.
//		successsorParent
    if(predecessor!=delete_node.left){
        predecessorparent.right= predecessor.left;
        predecessor.left = delete_node.left;
    
    
  }
  if(predecessor!=null)
  {predecessor.right=delete_node.right;
  }
  System.out.println("Pred is "+predecessor.val);
  return predecessor;
}

private void delete_node(IntNode t, int k){
  IntNode prev_del = t;
  while(t.val!=k){
      if(t.val<k)
      {   prev_del=t;
          t=t.right;
      }
      else{
            prev_del=t;
            t=t.left;
      }
    

  }
  System.out.println("Parent node is "+prev_del.val+" Deletion node is "+t.val);
   if(t.left==null && t.right!=null)
   {  if(prev_del.val>=k)
          prev_del.left=t.right;
      else
         prev_del.right=t.right;
   }
   else if(t.left==null && t.right==null)
   {
      if(prev_del.val>=k)
         prev_del.left=null;
      else
         prev_del.right=null;
   }
   else if(t.left!=null)
   {
      
     
      if(prev_del.val>k)
      { 
        prev_del.left=getPredecessor(t);
      }
      else 
      {
        prev_del.right=getPredecessor(t);
      }
   }
}
  

public void delete_node(int key){
     if(root.val==key)
        root =getPredecessor(root);
     else if(root.val>key)
           delete_node(root,key);
     else
           delete_node(root,key);
}

   

    public static void main(String args[]){
       //50, 40, 80, 20, 45, 60, 100, 70, 65, 42, 44, 30, 25, 35, 33 
       Binary_ST bst= new Binary_ST(50);
        bst.insertNode(40);
       bst.insertNode(80);
       bst.insertNode(20);
       bst.insertNode(45);
       bst.insertNode(60);
       bst.insertNode(100);
       bst.insertNode(70);
       bst.insertNode(65);
       bst.insertNode(42);
       bst.insertNode(44);
       bst.insertNode(30);
       bst.insertNode(25);
       bst.insertNode(35);
       bst.insertNode(33);
       
       bst.inorder();
       System.out.println("BREAK");
       System.out.println("50 is deleted");
       bst.delete_node(50);
       bst.inorder();
       System.out.println("BREAK");
       System.out.println("40 is deleted");
       bst.delete_node(40);
       bst.inorder();
       System.out.println("BREAK");
       System.out.println("65 is deleted");
       bst.delete_node(65);
       bst.inorder();
       System.out.println("BREAK");
       System.out.println("35 is deleted");
       bst.delete_node(35);
       bst.inorder();
       
    
    }
}


