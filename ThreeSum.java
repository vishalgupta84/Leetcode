import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    set.add(tmp);
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else
                    l++;
            }
        }
        for (List x : set) {
            ans.add(x);
        }
        return ans;
    }
}
