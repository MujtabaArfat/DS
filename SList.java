public class SList{
  private static class IntNode{
    public int item;
    public IntNode next;
    public IntNode(int i, IntNode n){
      item=i;
      next=n;
    }
     
    }

    public IntNode sential;
    public SList(){
      sential = new IntNode(1000,null);
    }
    public SList(int x){
      sential = new IntNode(1000,null);
      sential.next = new IntNode(x,sential.next);
    }
    
    public void addFirst(int val){
      sential.next= new IntNode(val,sential.next);
    }
    
    public void addLast(int val){
        IntNode p = sential;
        while(p.next!=null){
          p=p.next;
        }
        p.next= new IntNode(val,null);
    }

    public void addNodes(SList s){
      int val=100;
      for(int i=0;i<3;i++)
      {
        s.addFirst(val);
        val=val+1;
      }
    }
    
   private IntNode sort_items(IntNode p,IntNode min_node){
      //IntNode min_node = mins;
      IntNode key = p;
      IntNode temp = p;
      IntNode previous=null;
      IntNode min_next= null;
      IntNode last = null;
      while(key!=null && min_node!=last){
         while(temp!=null){
         if(min_node.item>=temp.item){
            previous = min_node;
            min_node = temp;
            temp=temp.next;
         }
         else
           temp=temp.next;
         }
         if(sential.next==key){
            sential.next= min_node;
            last=key;
         }
      
         min_next=min_node.next;
         min_node.next=key.next;
         key.next=min_next;
         previous.next=key;
         key= min_node.next;
         temp =key;
         min_node=key.next;
         
    }
    return sential.next;
   }

   public void sort_items(SList s){
      IntNode p = sential.next;
      sential = sort_items(p,p.next);
    }
    public void printList(SList s){
      IntNode p = sential.next;
      while(p.next!=null)
      {
           System.out.println(p.item);
           p=p.next;
    }
  }

    public static void main(String args[]){
      SList sample = new SList();
      sample.addNodes(sample);
      sample.sort_items(sample);
      sample.printList(sample);
    }
}
