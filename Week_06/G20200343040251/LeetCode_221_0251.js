/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
    let rows = matrix.length,
        cols = rows > 0 ? matrix[0].length : 0;
    let maxside = 0;

    let dp = new Array(rows + 1);
    for (let i = 0; i <= rows; i++) {
        dp[i] = new Array(cols + 1).fill(0);
    }

    for (let i = 1; i <= rows; i++) {
        for (let j = 1; j <= cols; j++) {
            if (matrix[i - 1][j - 1] === "1") {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                maxside = Math.max(maxside, dp[i][j]);
            }
        }
    }
    return maxside ** 2;
};