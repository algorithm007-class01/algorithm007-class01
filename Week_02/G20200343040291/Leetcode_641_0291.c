//动态数组val，队首下标front指向队首、队尾下标rear指向队尾的下一个 ,size为队列实际体积

typedef struct {

     int *val;
     short front, rear,size;
} MyCircularDeque;

//多分配一个空间（k+1）用以区分满队空队，rear指向队尾下一位

MyCircularDeque* myCircularDequeCreate(int k) {

     MyCircularDeque *obj = (MyCircularDeque *)malloc(sizeof(MyCircularDeque));
   
    if(!obj)
            return NULL;
    obj->val = (int *)malloc(sizeof(int) * ++k); 
    //注意k已经迭代为k+1

    obj->front = obj->rear = 0;
    obj->size = k;
    return obj;
}

bool myCircularDequeIsEmpty(MyCircularDeque* obj) {

    if(obj->front==obj->rear)
            return true;
    return false;
}

//rear的下一位是front则为满队
bool myCircularDequeIsFull(MyCircularDeque* obj) {

    if((obj->rear+1)%obj->size==obj->front)
            return true;
    return false;
}

bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {

    if(myCircularDequeIsFull(obj))
            return false;

    //front指向队首，故先左移front并取余数，再插入
    obj->front = (obj->front + obj->size - 1) % obj->size;
    *(obj->val + obj->front) = value;

    return true;
}

bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {

    if(myCircularDequeIsFull(obj))
            return false;

    //因为rear指向队尾下一位，所以先插入，再右移取余数
    *(obj->val + obj->rear) = value;
    obj->rear = ++obj->rear % obj->size;

    return true;
}

bool myCircularDequeDeleteFront(MyCircularDeque* obj) {

    if(myCircularDequeIsEmpty(obj))
            return false;
    //右移front并取余数
    obj->front = ++obj->front % obj->size;
    return true;
}

bool myCircularDequeDeleteLast(MyCircularDeque* obj) {

    if(myCircularDequeIsEmpty(obj))
            return false;

    //左移rear并取余数定位到队尾
    obj->rear = (obj->rear + obj->size - 1) % obj->size;
    return true;
}

int myCircularDequeGetFront(MyCircularDeque* obj) {

    if(myCircularDequeIsEmpty(obj))
            return -1;
    return *(obj->val + obj->front);
}

int myCircularDequeGetRear(MyCircularDeque* obj) {

    if(myCircularDequeIsEmpty(obj))
            return -1;
    
    return *(obj->val + (obj->rear+obj->size - 1)%obj->size);//注意rear-1并取余数
}

void myCircularDequeFree(MyCircularDeque* obj) {

    //先里后外
    free(obj->val);
    free(obj);
}
