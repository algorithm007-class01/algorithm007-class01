def search(self,num = None,target = None):
        if len(num) <1:
            return -1
        else:
            left,right = 0,len(num)-1
            while left<right:
                mid = (left + right) // 2
                if num[mid] == target:
                    return mid
                if num[right] == target:
                    return right
                if mid==left or mid == right:
                    return -1
                if num[mid]<num[right]:
                    if num[mid] < target and target < num[right] :
                        left = mid
                    else:
                        right = mid-1
                else:
                    if num[left] <target and target<num[mid]:
                        right = mid-1
                    else:
                        left = mid
        return -1
if __name__=='__main__':
    print(str(Revese().search([3,1],1)))
    print(str(Revese().search([3,0,1],1)))
    print(str(Revese().search([3,4,5,6,0,1,2],7)))