public class Binary_Search {
    public static void main(String[] args) {
        // 정렬이 되어 있어야 이분탐색 가능
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        System.out.println(binarySearch1(3, 0, arr.length-1, arr));
        System.out.println(binarySearch2(3, 0, arr.length-1, arr));
    }
    static int binarySearch1(int key, int low, int high, int[] arr) {
        if(low <= high) {
            int mid = (low + high) / 2;
            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                return binarySearch1(key ,low, mid-1, arr);
            } else {
                return binarySearch1(key, mid+1, high, arr);
            }
        }
        return -1;
    }
    static int binarySearch2(int key, int low, int high, int[] arr) {
        while(low <= high) {
            int mid = (low + high) / 2;
            if(key == arr[mid]) {
                return mid;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
