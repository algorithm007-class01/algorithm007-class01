// two pointers
func trap(height []int) int {
    if len(height) == 0 {
        return 0
    }
    w := 0
    l := 0
    r := len(height) - 1
    lMax := height[l]
    rMax := height[r]
    for l < r {
        if height[l] <= height[r] {
            l++
            if height[l] < lMax {
                w += lMax - height[l]
            } else {
                lMax = height[l]
            }
        } else {
            r--
            if height[r] < rMax {
                w += rMax - height[r]
            } else {
                rMax = height[r]
            }
        }
    }
    return w
}

// stack
func trap(height []int) int {
    w := 0 
    stack := []int{}
    cur := 0
    for cur < len(height) {
        for len(stack) > 0 && height[cur] > height[stack[len(stack) - 1]] {
            h := height[stack[len(stack) - 1]]
            stack = stack[:len(stack) - 1]
            if len(stack) == 0 {
                break
            }
            dis := cur - stack[len(stack) - 1] - 1
            min := min(height[stack[len(stack) - 1]], height[cur])
            w += dis * (min - h)
        }
        stack = append(stack, cur)
        cur++
    }
    return w
}

func min(x, y int) int {
    if x <= y {
        return x
    }
    return y
}
