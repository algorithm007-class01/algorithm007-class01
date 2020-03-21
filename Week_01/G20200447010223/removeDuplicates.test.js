/**
 * 第一次没有看完题目的代码;
 * 把 put 操作也加缓存了, 而不是做失效操作;
 */

function test(inputs, expectOutputs, solution) {
    inputs.forEach((input, index) => {
      let lru;
      const output = [...input];
      const newLen = solution(output);
      output.length = newLen;
      const isOk = output.length === expectOutputs[index].length && output.every((v, i) => v === expectOutputs[index][i]);
      if (isOk) {
        console.info(`test ${index} is ok: ${isOk}`);
      } else {
        console.error(`
          test ’${index}‘ has error,
          input:        ${JSON.stringify(input)},
          output:       ${JSON.stringify(output)}
          expectOutput: ${JSON.stringify(expectOutputs[index])}
          `);
      }
    });
  }

  const { inputs, expectOutputRight } = require("./removeDuplicates.test.data");
  
  test(inputs, expectOutputRight, require("./LeetCode_26_1223").removeDuplicates);
