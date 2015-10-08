import java.util.Iterator;
import java.util.NoSuchElementException;


public class DequeArrayImpl<Item> implements Iterable<Item> {

	Item deque[];
	Item temp[];
	int startPointer;
	int endPointer;
	int size;
	
	public DequeArrayImpl(){
		deque =  (Item[]) new Object[1]; 
		startPointer = endPointer = 0;
	}
	
	public boolean isEmpty(){		
		return !(size==0);
	}
	
	public int size() {
		return size;
	}
	private int positionCalc(int x){
		return (x)%deque.length;				
	}
	
	private void doublingArray(){
	   temp = (Item[]) new Object[2*size];
	   int tempNavigator=0;
	   for(int i = startPointer;i<size;i++,tempNavigator++){
		   temp[tempNavigator] = deque[i];
	   }
	   for(int j=endPointer;j>=0;j--){
		   temp[tempNavigator++] = deque[j];
	   }
	   deque = temp;
	}
	
   public void addFirst(Item item) {
	   	deque[positionCalc(--startPointer)] = item;
	
	   if(size == deque.length)
		   doublingArray();
	      
   }
   public void addLast(Item item)   {
	   deque[positionCalc(++endPointer)] = item;
		
	   if(size == deque.length)
		   doublingArray();
   }
   public Item removeFirst()    {
	   if(!isEmpty()){
		   Item removedItem = deque[startPointer];
		      startPointer = positionCalc(++startPointer);
		      size--;
		      return removedItem;
	   }else
		      throw new  NoSuchElementException();
	   
		     
	     
   }
   public Item removeLast(){
	   if(!isEmpty()){
		   Item removedItem = deque[endPointer];
		      startPointer = positionCalc(--endPointer);
		      size--;
		      return removedItem;
	   }else
		      throw new  NoSuchElementException();
	   
	   
	   
   }
	   
	@Override
	public Iterator<Item> iterator() {
		
		return new DequeIterator();
	}

	class DequeIterator<Item> implements Iterator<Item>{

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		

	}

	
}


