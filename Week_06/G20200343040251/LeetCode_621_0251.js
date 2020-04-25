/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function (tasks, n) {
    let map = new Map();
    for (let i = 0; i < tasks.length; i++) {
        if (map.has(tasks[i])) {
            map.set(tasks[i], map.get(tasks[i]) + 1);
        } else {
            map.set(tasks[i], 1);
        }
    }
    let arr = [...map.values()].sort((a, b) => b - a);
    let maxNum = arr[0];
    let res = (maxNum - 1) * (n + 1) + 1;
    let i = 1;
    while (i < arr.length && arr[i] === maxNum) {
        res++;
        i++;
    }
    return Math.max(tasks.length, res);
};