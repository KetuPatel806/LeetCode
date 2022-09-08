public class leetcodeHard1095 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        int target =3;
        int ans = search(arr,target);
        System.out.println(ans);
    }
    public static int search(int[] arr ,int target){
        int peakValue = findNumber(arr);
        int firstTry = orderAgnosticBS(arr,target,0,peakValue);
        if(firstTry != -1){
            return firstTry;
        }
        return orderAgnosticBS(arr,target,peakValue+1,arr.length-1);
    }
    public static int orderAgnosticBS(int[] arr,int target,int start , int end){

        //if ascending than going in line-19 and run ascending code
        //if descending than going in line-28 and run descending code
        boolean isAsc = arr[start]<arr[end];
        // start always greater than end
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                //target is left side of mid position
                if(target < arr[mid]){
                    end = mid - 1;
                }
                //target is right side of mid position
                else if(target > arr[mid]){
                    start = mid + 1;
                }
            }
            else{
                // target is left side of mid position
                if(target > arr[mid]){
                    end = mid - 1;
                }
                //target is right side of mid position
                else if(target < arr[mid]){
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    public static int findNumber(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start +(end - start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
}
