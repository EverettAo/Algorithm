package Labuladong及巧妙算法.调度问题.出租车调度;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 同主持人调度
 *
 * @see Labuladong及巧妙算法.调度问题.所需会议室数.Solution
 */
public class Solution {
    /**
     * @param n        活动的个数
     * @param startEnd 活动的始末时间
     * @return
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // 排序，头相等的，尾从小到大。为了尽快让主持人空闲
        // 头不相等的头从小到大
        Arrays.sort(startEnd, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        // 默认升序
        int min = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();    // 只放结束时间，即对活动按照结束时间排序
        queue.offer(min);
        for (int i = 0; i < n; i++) {
            // 因为是每新增一个活动时，才看是否有空闲的主持人（才能对优先队列里面的元素出队），所以最后队列的size就是所需的主持人数
            // 只提供结束时间，如果当前的开始时间小于队首的结束时间，说明没空闲
            // 如果当前的开始时间大于队首的结束时间，说明可以空闲一个，队首出队
            if (queue.peek() <= startEnd[i][0]) {
                queue.poll();
            }
            queue.offer(startEnd[i][1]);    // 看这个主持人什么时候结束当前主持的活动
        }
        return queue.size();
    }
}
