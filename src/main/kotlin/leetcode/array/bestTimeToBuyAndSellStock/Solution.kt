package leetcode.array.bestTimeToBuyAndSellStock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minPrice = prices[0]

        for (price in prices) {
            minPrice = minPrice.coerceAtMost(price)
            maxProfit = maxProfit.coerceAtLeast(price - minPrice)
        }

        return maxProfit
    }
}
