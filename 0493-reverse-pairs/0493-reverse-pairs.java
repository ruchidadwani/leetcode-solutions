class Solution {
    public int reversePairs(int nums[]) {
        int n=nums.length;
        return mergeSort(nums, 0, n-1);
    }

    int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if(low >= high)
            return cnt;
        int mid = (low+high)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid+1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }
    
    int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid+1;
        
        for(int i=low; i<=mid; i++) {
            while (right<=high && (long)arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt = cnt + (right - (mid+1));
        }
        return cnt;
        
    }

    void merge(int arr[], int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int k = 0;
        int left = low;
        int right = mid+1;

        while(left<=mid && right<=high) {
            if(arr[left] <= arr[right]) {
                temp[k++] = arr[left];
                left++;
            }
            else {
                temp[k++] = arr[right];
                right++;
            }
        }
        while(left<=mid) {
            temp[k++] = arr[left];
            left++;
        }
        while(right<=high) {
            temp[k++] = arr[right];
            right++;
        }
        for(int i=low; i<=high; i++) {
            arr[i] = temp[i-low];
        }

    }
}
