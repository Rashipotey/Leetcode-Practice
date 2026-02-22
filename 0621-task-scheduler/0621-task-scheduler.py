class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        min_intervals=0
        freq=Counter(tasks)
        max_heap=[-f for f in freq.values()]
        heapq.heapify(max_heap)
        time=0
        while max_heap:
            temp=[]
            cycle=n+1
            i=0
            while i<cycle and max_heap:
                count=heapq.heappop(max_heap)
                count+=1
                if count<0:
                    temp.append(count)
                time+=1
                i+=1
            for item in temp:
                heapq.heappush(max_heap,item)
            if max_heap:
                time+=(cycle-i)
        return time