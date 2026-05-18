import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int idx = q.poll();

                if (idx == n - 1)
                    return steps;

                // idx - 1
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // idx + 1
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }
                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }
                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna