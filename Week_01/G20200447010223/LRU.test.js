/**
 * 第一次没有看完题目的代码;
 * 把 put 操作也加缓存了, 而不是做失效操作;
 */

function test(inputs, expectOutputs, LRUCacheConstructor = LRUCache) {
  inputs.forEach((input, index) => {
    const output = [];
    let lru;
    input.operates.forEach((operator, operateIndex) => {
      switch (operator) {
        case "LRUCache":
          lru = new LRUCacheConstructor(...input.args[operateIndex]);
          output.push(null);
          break;
        case "put":
          lru.put(...input.args[operateIndex]);
          output.push(null);
          break;
        case "get":
          output.push(lru.get(...input.args[operateIndex]));
          break;
      }
    });
    const isOk = output.every((v, i) => v === expectOutputs[index][i]);
    if (isOk) {
      console.info(`test ${index} is ok: ${isOk}`);
    } else {
      console.error(`
        test ’${index}‘ has error,
        input->operators: ${JSON.stringify(input.operates)},
        input->args:      ${JSON.stringify(input.args)},
        output:           ${JSON.stringify(output)}
        expectOutput:     ${JSON.stringify(expectOutputs[index])}
        `);
    }
  });
}

const { inputs, expectOutputRight } = require("./LUR.test.data");

test(inputs, expectOutputRight, require("./LeetCode_146_1223").LRUCache);
