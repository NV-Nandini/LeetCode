class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> deque = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int right=0;right<nums.length;right++){  
          if(!deque.isEmpty() && deque.peekFirst()<=right-k) {
            deque.pollFirst();
          }
          while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
           deque.pollLast();
          }
          deque.offerLast(right);
           if (right >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
            }
            // Convert result list to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) res[i] = result.get(i);
        return res;

    }
}