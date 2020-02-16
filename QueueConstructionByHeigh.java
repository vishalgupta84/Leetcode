import java.util.*;

public class QueueConstructionByHeigh {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if( n == 0)
            return people;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])
                    return b[0] - a[0];
                else
                    return a[1] - b[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i=0;i<n;i++) {
            ans.add(new int[2]);
        }
        for (int i=0;i<n;i++) {
            ans.add(people[i][1], people[i]);
        }
        int[][] result = new int[n][2];
        for (int i=0;i<n;i++) {
            result[i][0] = ans.get(i)[0];
            result[i][1] = ans.get(i)[1];
        }
        return result;
    }
}
