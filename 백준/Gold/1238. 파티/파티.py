
import sys
import heapq as hq
input = sys.stdin.readline

def dijkstra(start):
  min_time = [int(1e9)] * (n+1)
  q = []
  min_time[start] = 0
  hq.heappush(q, [0,start])

  while q:
    cur_time,cur_node = hq.heappop(q)

    if min_time[cur_node] < cur_time:
      continue

    for next_node, next_time in graph[cur_node]:
      time = cur_time + next_time

      if min_time[next_node] > time:
        min_time[next_node] = time
        hq.heappush(q,[time,next_node])

  return min_time

n,m,x = map(int,input().split())
graph = [[] for _ in range(n+1)]
ans = -int(1e9)

for _ in range(m):
  a,b,t = map(int,input().split())
  graph[a].append([b,t])

for i in range(1,n+1):
  go = dijkstra(i)
  back = dijkstra(x)
  ans = max(ans,go[x] + back[i])
print(ans)