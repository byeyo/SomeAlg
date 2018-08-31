package sort;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Administrator
 *　@description　 通过数组索引全排列，最后用HashSet去重
 * @param <T> 
 */
public class AllListIndex<T> {
	int[] index ;
	T[] data ;
	HashSet<LinkedList<T>> deDupResult;
	boolean[] isVisited ;
	public AllListIndex(T[] data){
		this.index = new int[data.length];
		this.data = data;
		deDupResult = new HashSet<>();
		isVisited = new boolean[data.length];
		allSeq(new LinkedList<T>(), data.length);
	}
	public void allSeq(LinkedList<T> ele,int length ) {
		if(length <= 0) {
			deDupResult.add(ele);
			return;
		}
		for(int i = 0 ; i < index.length ; i ++){
			if(!isVisited[i]) {
				isVisited[i] = true;
				ele.add(data[i]);
				allSeq(new LinkedList<T>(ele), length - 1);
				isVisited[i] = false;
				ele.removeLast();
			}
		}
	}
	public static void main(String[] args) {
		String[] data = {"I","Love","you","bitcoin"};
		AllListIndex<String> al = new AllListIndex<>(data);
		int count = 0;
		for(LinkedList<String> l : al.deDupResult) {
			for(String i : l) {
				System.out.print(i+" ");
			}
			count++;
			System.out.println("");
		}
		System.out.println(count);
	}
}
