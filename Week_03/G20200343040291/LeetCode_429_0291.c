#define MAXSIZE 5000
#define MAXDEPTH 1000

typedef struct{
    struct Node** data;
    int front;
    int rear;
}SeqQueue;

SeqQueue* createSeqQueue();
int QueueLength(SeqQueue* obj);
bool QueueEmpty(SeqQueue* obj);
bool QueueFull(SeqQueue* obj);
void EnQueue(SeqQueue* obj, struct Node* node);
struct Node* DeQueue(SeqQueue* obj);

int** levelOrder(struct Node* root, int* returnSize, int** returnColumnSizes){
    int** nums = malloc(sizeof(int *) * MAXDEPTH); //定义二维数组存储节点值
    int* sizes = malloc(sizeof(int) * MAXDEPTH);  //定义一维数组存储每一层节点个数
    int i, j, k;
    for(i=0; i<MAXDEPTH; i++)
        nums[i] = (int *)malloc(sizeof(int) * MAXSIZE);
    
    i = -1;
    if(root){
        SeqQueue* Q = createSeqQueue();
        EnQueue(Q, root);

        while(!QueueEmpty(Q)){
            i++;
            sizes[i] = QueueLength(Q);
            //QueuePrint(Q);

            for(j=0; j<sizes[i]; j++){
                k = (Q->front+j)%MAXSIZE;
                nums[i][j] = Q->data[k]->val;
            }
            
            k = Q->rear;
            struct Node* temp;

            while(Q->front != k){
                temp = Q->data[Q->front];
                DeQueue(Q); //弹出

                for(j=0; j<temp->numChildren; j++)
                    EnQueue(Q, temp->children[j]);
            }
        }
    }

    *returnSize = i+1; //二叉树的深度，即层数
    int* columnSizes = malloc(sizeof(int) * (*returnSize));
    for(i=0; i<*returnSize; i++)
        columnSizes[i] = sizes[i];
    *returnColumnSizes = columnSizes;
    
    return nums;
}

//定义循环队列并初始化
SeqQueue* createSeqQueue(){
    SeqQueue* obj;
    obj = (SeqQueue *)malloc(sizeof(SeqQueue));
    obj->data = (struct Node **)malloc(sizeof(struct Node *) * MAXSIZE);
    obj->front = 0;
    obj->rear = 0;
    return obj;
}

//队列长度
int QueueLength(SeqQueue* obj){
    return (obj->rear - obj->front + MAXSIZE)%MAXSIZE;
}

//队列是否为空
bool QueueEmpty(SeqQueue* obj){
    return obj->front == obj->rear;
}

//队列是否为满
bool QueueFull(SeqQueue* obj){
    return (obj->rear+1)%MAXSIZE == obj->front;
}

//入队
void EnQueue(SeqQueue* obj, struct Node* node){
    if( (obj->rear+1)%MAXSIZE != obj->front ){
        obj->data[obj->rear] = node;
        obj->rear = (obj->rear+1)%MAXSIZE;
    }
}

//出队
struct Node* DeQueue(SeqQueue* obj){
    if(obj->front != obj->rear){
        int k = obj->front;
        obj->front = (obj->front+1)%MAXSIZE;
        return obj->data[k];
    }
    return NULL;
}
