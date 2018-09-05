package sort;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class AllSeq<T> {
	int[] index;
	T[] data ;
	LinkedList<LinkedList<T>> result = new LinkedList<>();
	public static void main(String[] args) {
		Integer[] data = {2,3,4};
		AllSeq<Integer> as = new AllSeq(data);
		as.step(0);
		for(LinkedList<Integer> ele : as.result) {
			for(Integer dataEle : ele) {
				System.out.print(dataEle);
			}
			System.out.println();
		}
	}
	public AllSeq(T[] data) {
		if(data.length <= 0) {
			throw new RuntimeErrorException(null, "length <= 0");
		}
		this.data = data;
		index = new int[data.length];
		for(int i =0 ; i < data.length ; i ++) {
			index[i] = i;
		}
	}
	public void step(int cur) {
		if(cur == index.length - 1) {
			LinkedList<T> eleList = new LinkedList<>();
			for(int i : index) {
				eleList.add(data[i]);
				System.out.print( i+" ");
			}
			System.out.println();
			result.add(eleList);
			return;
		}
		//step(cur+1);
		for(int i = cur  ;i < index.length ; i ++) {
			int temp = index[i];
			index[i] = index[cur];
			index[cur] = temp;		
			step(cur+1);
			temp = index[i];
			index[i] = index[cur];
			index[cur] = temp;	
		}
	}
}
