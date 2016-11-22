import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class PriorityQueue<E> implements RMCPriorityQueue<E> {

	private E[] data;
	private int size = 0;
	private Comparator<E> comparator;

	public PriorityQueue(Comparator<E> comparator, int start) {
		this.data = (E[]) new Object[start];
		this.comparator = comparator;
	}

	public PriorityQueue(Comparator<E> comparator) {
		this(comparator, 23);
	}

	private void percolateUp(int i) {
		if (data [parentOf(i)] != null) {
			if (comparator.compare(data[i], data[parentOf(i)]) > 0) {
				swap(i, parentOf(i));
				percolateUp(parentOf(i));
			}
		}
	}

	public void percolateDown(int i) {
		if (rightChildOf(i) >= size) {
			if (comparator.compare(data[i], data[rightChildOf(i)]) < 0) {
				swap(i, rightChildOf(i));
			}
		}
		if (!(leftChildOf(i) >= size) && !(rightChildOf(i) >= size)) {
			if (comparator.compare(data[leftChildOf(i)], data[rightChildOf(i)]) > 0) {
				if (comparator.compare(data[i], data[leftChildOf(i)]) < 0) {
					swap(i, (leftChildOf(i)));
					percolateDown(leftChildOf(i));
				}
			} else {
				if (comparator.compare(data[i], data[rightChildOf(i)]) < 0) {
					swap(i, rightChildOf(i));
					percolateDown(rightChildOf(i));
				}
			}
		}

	}

	@Override
	public E peek() {
		return data[0];
	}

	@Override
	public E poll() {
		E temp = peek();
		data[0] = data[size];
		size = size - 1;
		return temp;
	}

	@Override
	public void add(E elt) {
		
		if (data.length == size) {
			growArray();
		}

		data[size] = elt;
		
		percolateUp(size);
		size = size + 1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public int leftChildOf(int i) {
		return (2 * i) + 1;
	}

	public int rightChildOf(int i) {
		return (2 * i) + 2;
	}

	public int parentOf(int i) {
		return (i - 1) / 2;
	}

	public void swap(int a, int b) {
		E temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}

	@SuppressWarnings("unchecked")
	public void growArray() {
		E[] temp;
		temp = (E[]) new Object[data.length * 2];

		for (int x = 0; x < data.length; x++) {
			temp[x] = data[x];
		}
		data = temp;
	}

	public void display() {
		for(int x=0;x<size;x++){
			System.out.println(data[x]);
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Integer> john = new PriorityQueue<Integer>(new IntegerComparator(), 10);
		Scanner scan = new Scanner (System.in);
		int[] intarray= new int[Integer.parseInt(args[0])];
		scan.close();
		Random rng = new Random();
		for (int x = 0; x < intarray.length; x++) {
			intarray[x]=rng.nextInt(1000);
			if (intarray.length<=20){
				System.out.println(intarray[x]);
			}
		}
		for (int x=0;x<intarray.length;x++){
			john.add(intarray[x]);
		}
		System.out.println();
		if(intarray.length<=20){
			john.display();
		}

	}

}
