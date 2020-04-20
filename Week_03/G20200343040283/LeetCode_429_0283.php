<?php

/**
 *
 * N叉树的层序遍历
 * @param $root
 *
 * @return array
 */
function levelOrder($root) {
    if($root === null){
        return [];
    }
    $res = [];
    $queue = new \SplQueue();
    $queue->enqueue($root);
    while(!$queue->isEmpty()){
        $len = $queue->count();
        $tmp = [];
        //输出当前层
        for ($i = 0; $i < $len; $i++) {
            $node = $queue->dequeue();
            $tmp[] = $node->val;
            //将子节点入队
            foreach ($node->children as $child) {
                $queue->enqueue($child);
            }
        }
        $res[] = $tmp;
    }
    return $res;
}
