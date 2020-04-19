# -*- coding: utf-8 -*-


class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """

        if not matrix:
            return 0
        res = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[ 0 ])):
                if matrix[ i ][ j ] == '1':
                    matrix[ i ][ j ] = 1
                    if i == 0 or j == 0:
                        res = max(matrix[ i ][ j ] , res)
                    else:
                        matrix[ i ][ j ] = min(matrix[ i - 1 ][ j ] ,
                                               matrix[ i - 1 ][ j - 1 ] ,
                                               matrix[ i ][ j - 1 ]) + 1
                        res = max(matrix[ i ][ j ] , res)
                else:
                    matrix[ i ][ j ] = 0
        return res * res
