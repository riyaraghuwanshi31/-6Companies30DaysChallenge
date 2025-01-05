class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }
        
        // Step 2: Use Dijkstra's algorithm for each city
        int minReachableCities = Integer.MAX_VALUE;
        int cityWithMinReachable = -1;
        
        for (int i = 0; i < n; i++) {
            int reachableCount = countReachableCities(i, graph, distanceThreshold, n);
            
            // We want the city with the smallest reachable count, but if equal, pick the one with the largest index
            if (reachableCount < minReachableCities || (reachableCount == minReachableCities && i > cityWithMinReachable)) {
                minReachableCities = reachableCount;
                cityWithMinReachable = i;
            }
        }
        
        return cityWithMinReachable;
    }
    
    private int countReachableCities(int start, List<int[]>[] graph, int distanceThreshold, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        // Dijkstra's algorithm to find the shortest path from `start`
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            
            // If we already found a shorter path, skip it
            if (d > dist[u]) continue;
            
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0], weight = neighbor[1];
                int newDist = dist[u] + weight;
                
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(new int[]{v, newDist});
                }
            }
        }
        
        // Count how many cities are within the distanceThreshold
        int reachableCities = 0;
        for (int i = 0; i < n; i++) {
            if (i != start && dist[i] <= distanceThreshold) {
                reachableCities++;
            }
        }
        
        return reachableCities;
    }
}
