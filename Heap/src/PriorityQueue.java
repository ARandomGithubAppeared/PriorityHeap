import java.util.Comparator;

public class PriorityQueue<E> implements RMCPriorityQueue<E>{

	private E[] data;
	private int size=0;
	private Comparator<E> comparator;
	
	public PriorityQueue(Comparator<E> comparator, int start) {
		this.data=(E[]) new Object[start];
		// TODO Auto-generated constructor stub
	}
	
	public PriorityQueue(Comparator<E> comparator){
		this(comparator, 23);
	}
	
	private void percolateUp(int i){
		//code stuff;
	}
	
	
	@Override
	public E peek() {
		return data[0];
	}

	@Override
	public E poll() {
		E temp=peek();
		data[0]=data[size];
		size=size-1;
		return temp;
	}

	@Override
	public void add(E elt) {
		if (data.length == size){
			E[] temp;
			temp =(E[]) new Object[data.length*2];
			
			for(int x=0;x<data.length;x++){
				temp[x]=data[x];
			}
			data=temp;	
		}
		
		
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
