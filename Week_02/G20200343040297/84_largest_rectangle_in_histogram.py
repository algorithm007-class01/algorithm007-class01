class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        st = [(-1,-1)]
        max_area = 0
        i = 0
        while i < len(heights):
            if heights[i] >= st[-1][1]:
                st.append((i,heights[i]))
                i += 1
            else:
                area = st[-1][1] * (i - st[-2][0] - 1)
                st.pop()
                max_area = max(max_area, area)
        for j in range(len(st)-1,0,-1):
            area = st[-1][1] * (i - st[-2][0] - 1)
            st.pop()
            max_area = max(max_area, area)
        return max_area