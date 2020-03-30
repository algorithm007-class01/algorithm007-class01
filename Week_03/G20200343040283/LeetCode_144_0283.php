<?php

/**
 *
 * 二叉树的前序遍历
 * @param $root
 *
 * @return array
 */
function preorderTraversal($root)
{
    $stack = new SplStack();
    $res = [];
    $stack->push($root);
    while ($stack->count()) {
        $cur = $stack->pop();
        $res[] = $cur->val;
        if ($cur->right !== null) $stack->push($cur->right);
        if ($cur->left !== null) $stack->push($cur->left);
    }

    return $res;
}

