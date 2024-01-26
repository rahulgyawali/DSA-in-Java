public class MergeSort {

    public static void merge(int low ,int mid, int high, int[] A){

        int left = low;
        int right = mid+1;
        int k = 0;
        int[] temp = new int[high-low+1];
        while(left <= mid && right <= high){
            if(A[left] <= A[right]){
                temp[k] =A[left];
                k++;
                left++;
            }else{
                temp[k] = A[right];
                k++;
                right++;
            }
        }
        while(left <= mid){
            temp[k] = A[left];
            left++;
            k++;
        }
        while(right <= high){
            temp[k] = A[right];
            right++;
            k++;
        }
        for(int i=low; i <= high; i++){
            A[i] = temp[i-low];
        }
    }

    public static void mergeSort(int low, int high,int[] A){
            if(low == high) return;
            int mid = (low+high)/2;                //Split the Array into two
            mergeSort(low, mid, A);             //Call merge sort from low to mid
            mergeSort(mid+1, high, A);           //Call merge sort from mid+1 to high
            merge(low,mid,high,A);
        
    }

    public static void main(String args[]){
        int[] A = {0,-1,-9,3,2,12,10,6,7,4};
        System.out.println("Before Sorting");
        for(int x: A){
            System.out.print(x+" ");
        }
        System.out.println();
        mergeSort(0, A.length-1, A);
        System.out.println("After Sorting");
        for(int x: A){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
