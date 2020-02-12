import java.util.*;

class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();
		int n = strs.length;
		for(int i=0;i<n;i++) {
			char[] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
            String c = new String(tmp);
			if(map.get(c) == null) {
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				map.put(c, temp);
			}
			else {
				map.get(c).add(strs[i]);
			}
		}
		for(Map.Entry entry : map.entrySet()) {
			List<String> list = (List) entry.getValue();
			ans.add(list);
		}
		return ans;
    }
}