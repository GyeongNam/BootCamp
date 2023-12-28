import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] HeapArr = {7,6,5,8,3,5,9,1,7};

        // 최소 힙구성 : n/2번만큼 heapify 수행
        for(int i = HeapArr.length/2-1; i>=0; i--){
            heapify(HeapArr, i, HeapArr.length);
        }
        System.out.println(Arrays.toString(HeapArr));

        // 최초 힙구성 이후에 root 노드와 마지막 노드와 change
        for(int i =HeapArr.length-1; i>0; i--){
            swap(HeapArr, 0, i);
            heapify(HeapArr, 0, i);
        }
        System.out.println(Arrays.toString(HeapArr));
    }

    static void heapify( int[] HeapArr, int root, int arr_size){
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int temp = root;
        if(left<arr_size && HeapArr[left] > HeapArr[temp]){
            temp = left;
        }
        if(right<arr_size && HeapArr[right] > HeapArr[temp]){
            temp = right;
        }

        if(temp != root){
            swap(HeapArr, root, temp);
            heapify(HeapArr, temp, arr_size);
        }
    }
    static void swap(int[] HeapArr, int x, int y){
        int num = HeapArr[x];
        HeapArr[x] = HeapArr[y];
        HeapArr[y] = num;
    }
}