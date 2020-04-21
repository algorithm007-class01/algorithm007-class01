package G20200343040039

func canCross(stones []int) bool {
	if stones[1] > 1 {
		return false
	}

	hashSet := make(map[int]struct{})

	for i := 0; i < len(stones); i++ {
		if i > 3 && stones[i] >= 2*stones[i - 1] {//如果下一个石头位置序号为当前序号的两倍，肯定不符合
			return false;
		}
		hashSet[stones[i]] = struct{}{}
	}

	return check(stones[len(stones) - 1], hashSet, 1, 1)
}

func check(last int, hashSet map[int]struct{}, index int, step int) bool {
	if(index == last){
		return true;
	}

	if _, exist := hashSet[index + step + 1]; exist{
		if(check(last, hashSet, index + step + 1, step + 1)){
			return true;
		}
	}
	if _, exist := hashSet[index + step]; exist{
		if(check(last, hashSet, index + step, step)){
			return true;
		}
	}

	if step - 1 > 0 {
		if _, exist := hashSet[index + step - 1]; exist{
			if(check(last, hashSet, index + step - 1, step - 1)){
				return true;
			}
		}
	}
	return false;
}