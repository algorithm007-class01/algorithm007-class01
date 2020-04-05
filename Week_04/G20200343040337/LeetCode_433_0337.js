/*
 * @lc app=leetcode.cn id=433 lang=javascript
 *
 * [433] 最小基因变化
 *
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (48.73%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    3.2K
 * Total Submissions: 6.7K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 
 * 现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回
 * -1。
 * 
 * 注意:
 * 
 * 
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 
 * 
 * 示例 1:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * 返回值: 1
 * 
 * 
 * 示例 2:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * 返回值: 2
 * 
 * 
 * 示例 3:
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * 返回值: 3
 * 
 * 
 */

// @lc code=start
/**
 * @param {string} start
 * @param {string} end
 * @param {string[]} bank
 * @return {number}
 */
var minMutation = function(start, end, bank) {
  bank = new Set(bank);
  if (!bank.has(end)) return -1;

  let dict = new Map([
    ["A", "CGT"],
    ["C", "AGT"],
    ["G", "ACT"],
    ["T", "ACG"]
  ]);
  let front_queue = new Set([start]);
  let end_queue = new Set([end]);
  let step = 0;

  while (front_queue.size > 0) {
    step += 1;
    let next_front = new Set();
    for (let word of front_queue.values()) {
      for (let i = 0; i < word.length; i++) {
        for (let c of dict.get(word[i])) {
          let new_word = word.slice(0, i) + c + word.slice(i + 1);
          if (end_queue.has(new_word)) {
            return step;
          }
          if (bank.has(new_word)) {
            next_front.add(new_word);
            bank.delete(new_word);
          }
        }
      }
    }
    front_queue = next_front;
    if (end_queue.size < front_queue.size) {
      let tmp = end_queue;
      end_queue = front_queue;
      front_queue = tmp;
    }
  }
  return -1;
};
// @lc code=end

