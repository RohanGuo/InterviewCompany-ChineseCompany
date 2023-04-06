package mercury;

public class MedianSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {1};
		double out = findMedianSortedArrays(nums1, nums2);
		System.out.println(out);
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length;
        int len = nums1.length+nums2.length; 
        int cut1 = 0;
        int cut2 = 0;
        
        while (left <= nums1.length){
            cut1 = (left+right)/2;
            cut2 = len/2 - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE: nums1[cut1-1];
            int r1 = cut1 == nums1.length? Integer.MAX_VALUE: nums1[cut1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE: nums2[cut2-1];
            int r2 = cut2 == nums2.length? Integer.MAX_VALUE: nums2[cut2];
            if (l1 > r2){
                right = cut1-1;
            }else if (l2 > r1){
                left = cut1+1;
            }else{
                int leftValue = Math.max(l1, l2);
                int rightValue = Math.min(r1, r2);
                if (len % 2 == 0) {
                    return (leftValue+rightValue)*1.0/2;              
                }else{
                    return rightValue;
                }
                
            }
        }
        return -1;
        
    }

}
