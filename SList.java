import java.util.Scanner;
public class SList{
  //Class IntNode is used to create Node with item storing the value and next pointing to the next node.
  private static class IntNode{
    public int item;
    public IntNode next;
    public IntNode(int i, IntNode n){
      item=i;
      next=n;
    }
     
    }
    //Sential is an intnode where sential marks an arbitary head and sential.next points to the first node int the list.
    public IntNode sential;
    Scanner sc = new Scanner(System.in);
    public SList(){
      sential = new IntNode(1000,null);
      
    }
    public SList(int x){
      sential = new IntNode(1000,null);
      sential.next = new IntNode(x,sential.next);
    }
    //addFirst method adds nodes in front of the SList.
    public void addFirst(int val){
      sential.next= new IntNode(val,sential.next);
    }
    //addLast method adds nodes at the end of the SList.
    public void addLast(int val){
        IntNode p = sential;
        while(p.next!=null){
          p=p.next;
        }
        p.next= new IntNode(val,null);
    }
    //addNodes adds the node in SList by asking user input.
    public void addNodes(SList s){
      System.out.println("Enter 15 values to be added in SingleLinked List ");
      int val=sc.nextInt();
      s.addFirst(val);
      for(int i=0;i<14;i++)
      { System.out.println(val+" is stored in the SList.");
        val =sc.nextInt();
        s.addFirst(val);
       
      }
      

    }
    
     public void SelectionSort(){
      //Points to the first element in the list.
      IntNode head =sential.next;
        //a corresponds to the previous of the key element in the list.
        //b corresponds to the present key element in the list.
        //d corresponds to the node with the minimum value in the list.
        //r corresponds to the temporary node in the list.

        IntNode a, b, c, d , r;

        a = head;
        b = head;
        while (b.next != null)
        {
          c = b.next;
          d = b.next;
          //while loop corressponds to the traversing of the SList while there are min_nodes are present or as long as list is not sorted.
          while (d != null)
          {//If the node with the minimum value and the key node are next to each other then simple swapping is performed by interchanging next pointers of each node to point each other.
            if  (b.item > d.item) 
            {
              if (b.next == d) 
              {
                if (b == head)
                {
                  b.next = d.next;
                  d.next = b;
                  //corresponds to the swapping of the current key and the min_node at that instant.
                  r = b;
                  b = d;
                  d = r;  
                  
                  c = d;
                  //shifting of head to point to mark the new first element in the list.
                  head = b;
                  //Moving the min_node to the next element in the list so as to reiterate the list.
                  d = d.next;
                }
                else{
                  //If b is the head of the list but the two nodes are not side by side.
                  //Involves swapping of the nodes by relinking pointers.

                  b.next = d.next;
                  d.next = b;
                  a.next = d; 
                  //Shifting of b node to its current position so as to move the key node to the next node to begin the reiteration of list for further sort.

                  r = b;
                  b = d;
                  d = r;

                  c = d;
                  
                  d = d.next;
                }
              }
              else{
                
                  if (b == head){
                    r = b.next;
                    b.next = d.next;
                    d.next = r;
                    c.next = b;
                    r = b;
                    b = d;
                    d = r;
                    c = d ;
                    d = d.next;
                    head = b; 
                  }
                  else{
                    //if key_node is not the head of the list neither min_node is next to eachother.
                    //involves rearrangement of nodes and movement of the previous key value to the current min_node so as to perform correct linking.

                    r = b.next;
                    b.next = d.next;
                    d.next = r;
                    c.next = b;
                    a.next = d;
                    r = b;
                    b = d;
                    d = r;
                    c = d ;
                    d = d.next;
                  }
                }
              }
              else{
                c=d;
                d=d.next;
              }
  
            }
            a= b;
          b = b.next;
            
          }
        sential.next = head;
          
        }
        
    
   
    public void printList(SList s){
      //This method is used to display the node values in the link list.

      IntNode p = sential.next;
      while(p.next!=null)
      {
           System.out.print(p.item+" ");
           p=p.next;
    }
  }

    public static void main(String args[]){
      SList sample = new SList();
      sample.addNodes(sample);
      System.out.println("The unsorted list is as follows");
      sample.printList(sample);
      System.out.println("\n The Sorted SList is as follows:");
      sample.SelectionSort();
      sample.printList(sample);
    }
}

