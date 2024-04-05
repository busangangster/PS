import sys
from heapq import heappush, heappop
from collections import defaultdict
input = sys.stdin.readline


def dijkstra(S):
    Q = list()
    heappush(Q, (0, S))

    D = [float('inf')] * (N + 1)
    D[S] = 0

    while Q:
        SD, SN = heappop(Q)

        if D[SN] < SD:
            continue

        for FN, FD in L[SN]:
            d = SD + FD
            if D[FN] > d and H[SN] < H[FN]:
                D[FN] = d
                heappush(Q, (d, FN))
                
    return D


N, M, D, E = map(int, input().split())
H = [0] + list(map(int, input().split()))
L = defaultdict(list)
for i in range(M):
    a, b, n = map(int, input().split())
    L[a].append((b, n))
    L[b].append((a, n))

S = dijkstra(1)
F = dijkstra(N)
MAX = - float('inf')
for i in range(2, N):
    MAX = max(MAX, H[i] * E - (S[i] + F[i]) * D)
print(MAX if MAX != - float('inf') else "Impossible")