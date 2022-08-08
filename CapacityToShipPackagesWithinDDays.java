class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        /*
         * Time Complexity: O(log n) 
         * Space Complexity: O(1)
         * Logic -> To find the low (max (weights)) and high (sum (weights))
         *
         */
        if (weights.length == 0 || weights == null) return 0;
        
        // logic - binary search
        int low = 0, high = 0;
        for (int i: weights) {
            if (low < i) {
                low = i;
            }
            high += i;
        }
        
        while (low <= high) {
            int mid = low + (high-low)/2;
            
            int DAYS = 1, count = 0;
            for (int i=0; i<weights.length; i++) {                                ;
                if (count + weights[i] > mid) {
                    DAYS++;
                    if (DAYS > days) break;
                    count = weights[i];
                }
                else {
                    count = count + weights[i];   
                }                
            }
            
            if (DAYS <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
