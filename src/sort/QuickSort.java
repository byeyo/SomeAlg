package sort;

/**
 * @author Administrator
 *　@description　快速排序，简化版本
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] num = {2,3,4,1,5,4,7,0};//{2,3,4,1,5,4,7,0};
		sort(num, 0, num.length - 1);
		System.out.println(num.toString());
	}
	public static int getIndex(int num[], int start , int end) {
		int anchor = num[end];
		int left = start;
		for(int i = start ; i < end ; i ++) {
			if(num[i]< anchor) {
				exch(left++,i,num);
			}
		}
		exch(left, end, num);
		return left ;
	}
	public static void exch(int index1, int index2 , int[] num) {
		int temp = num[index1];
		num[index1] = num[index2];
		num[index2] = temp;
	}
	public static void sort(int num[], int start , int end) {
		if(start > end) {
			return;
		}
		int index1 = getIndex(num, start, end);
		sort(num,start,index1 - 1);
		sort(num,index1 + 1,end);
	}
}
