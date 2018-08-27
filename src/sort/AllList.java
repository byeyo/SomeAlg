package sort;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Administrator  遍历图的所有路径，全排列
 *　@description　
 */
public class AllList {
	char[] data;
	HashSet<String> list = new HashSet<>();
	Graph graph = null;
	public AllList(String str){
		data = str.toCharArray();
		graph = new Graph(data.length);
		boolean[] isVisited  = new boolean[data.length];
		for(int i = 0 ; i < data.length - 1;  i ++){
			for(int j = i + 1; j < data.length ; j ++){
				graph.add(i, j);
			}
		}
		for(int i = 0 ; i < data.length ; i ++){
			LinkedList<Integer> ini = new LinkedList<Integer>();
			s(i, 1, isVisited, ini);
			for(int j = 0 ; j < isVisited.length ; j ++){
				isVisited[j] = false;
			}
		}
	}
	public void s(int v ,int length, boolean[] isVisited,LinkedList<Integer> single){
		isVisited[v] = true;
		single.add(v);
		if(length == data.length){
			StringBuilder sb = new StringBuilder();
			for(Integer i: single){
				sb.append(data[i]);
			}
			list.add(sb.toString());
			isVisited[v] = false;
			single.removeLast();
			return;
		}
		for(int w : graph.adj(v)){
			if(isVisited[w]){
				continue;
			}
			s(w, length + 1, isVisited, single);
		}
		isVisited[v] = false;
		single.removeLast();
	}
	public static void main(String[] args){
		AllList b = new AllList("1235");
		int count = 0;
		for(String string : b.list){
			System.out.println(string);
			count++;
		}
		System.out.println("end"+count);
	}
}
class Graph{
	int size;
	LinkedList<Integer>[] list ;
	public Graph(int size){
		this.size = size;
		list = new LinkedList[size];
		for(int i = 0 ; i < size ; i ++){
			list[i] = new LinkedList<>();
		}
	}
	public LinkedList<Integer> adj(int v){
		return list[v];
	}
	public void add(int v, int w){
		list[v].add(w);
		list[w].add(v);
	}
}
