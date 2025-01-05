class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         int n=nums.length;
        ArrayList<Integer> lst=new ArrayList<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){// is odd
            lst.add(i);
            }
        }
        lst.add(n);
        int start=0;
        for(int i=0;i+k<lst.size();i++){
            int left=lst.get(i)-start+1;
            int right=lst.get(i+k)-lst.get(i+k-1);
            ans=ans+(left*right);
            start=lst.get(i)+1;
        }
        return ans;
    }
}
