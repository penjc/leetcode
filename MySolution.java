

class MySolution{

    static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swap;
        for(int i =0;i<n;i++){
            swap = false;
            for(int j = 0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }


    public static void main(String[] args){
        int[] arr = new int[]{1,3,5,2,4,5,6,2};
        bubbleSort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}