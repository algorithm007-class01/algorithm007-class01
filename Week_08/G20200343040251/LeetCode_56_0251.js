/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if(intervals.length<=0) return intervals;
    intervals.sort((a,b)=>a[0] - b[0]);
    let res = [intervals[0]];
    for(let i=1; i<intervals.length; i++){
        let pre = res[res.length-1];
        let record = intervals[i];
        if(pre[1]< record[0]) res.push(record);
        else pre[1] = Math.max(pre[1], record[1]);
    }

    return res;
};