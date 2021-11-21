



#define MIN (-1)

typedef struct  node {
    int val;
    struct node *next;
} node_t;

//
// head: ->  x1 ->  x2 -> x3 ->tail
// tail: ->  x2
//                        
//
// 
typedef struct {
    int size;
    int capacity;

    struct node *head;
    struct node *tail;
} MyCircularDeque;

int isEmpty(MyCircularDeque *q) {
    return q->size == 0;
}
int isFull(MyCircularDeque *q) {
    return q->size == q->capacity;
}




MyCircularDeque* myCircularDequeCreate(int k) {
    MyCircularDeque *q = malloc(sizeof(MyCircularDeque));
    if (q == NULL) {
        return 0;
    }
    q->size = 0;
    q->capacity = k;

    node_t *head = malloc(sizeof(struct node));
    node_t *tail = malloc(sizeof(struct node));
    if (head == NULL || tail == NULL) {
        if (head != NULL) {
            free(head);
        }
        if (tail != NULL) {
            free(tail);
        }
        free(q);
        return 0;
    }
    head->next = tail;
    tail->next = head;

    q->head = head;
    q->tail = tail;
    return q;
}


bool myCircularDequeInsertFront(MyCircularDeque* obj, int value) {
    if (obj == NULL) {
        return 0;
    }
    if (isFull(obj)) {
        return 0;
    }
    node_t *n = malloc(sizeof(struct node));
    if (n == NULL) {
        return 0;
    }
    obj->size++;
    n->val = value;

    n->next = obj->head->next;
    obj->head->next = n;

    if (n->next == obj->tail) {
        obj->tail->next = n;
    }

    return 1;
}

bool myCircularDequeInsertLast(MyCircularDeque* obj, int value) {
    if (obj == NULL) {
        return 0;
    }
    if (isFull(obj)) {
        return 0;
    }
    node_t *n = malloc(sizeof(struct node));
    if (n == NULL) {
        return 0;
    }
    obj->size++;
    n->val = value;

    if (obj->head->next == obj->tail) {
        n->next = obj->tail;
        obj->tail->next = n;
        obj->head->next = n;
    } else {
        obj->tail->next->next = n;
        n->next = obj->tail;
        obj->tail->next = n;
    }
    return 1;
}

bool myCircularDequeDeleteFront(MyCircularDeque* obj) {
    if (obj == NULL) {
        return 0;
    }
    if (isEmpty(obj)) {
        return 0;
    }
    obj->size--;
    node_t *temp = obj->head->next;
    if (temp->next == obj->tail) {
        obj->head->next = obj->tail;
        obj->tail->next = obj->head;
    } else {
        obj->head->next = temp->next;
    }
    free(temp);
    return 1;
}

bool myCircularDequeDeleteLast(MyCircularDeque* obj) {
    if (obj == NULL) {
        return 0;
    }
    if (isEmpty(obj)) {
        return 0;
    }
    obj->size--;
    node_t *temp = obj->tail->next;

    if (temp == obj->head->next) {
        obj->head->next = obj->tail;
        obj->tail->next = obj->head;
    } else {
        node_t *p = obj->head;
        while(p->next->next != obj->tail) {
            p = p->next;
        }
        obj->tail->next = p;
        p->next = obj->tail;
    }
    free(temp);
    return 1;

}

int myCircularDequeGetFront(MyCircularDeque* obj) {
    if (obj == NULL) {
        return MIN;
    }
    if (isEmpty(obj)) {
        return MIN;
    }
    return obj->head->next->val;
}

int myCircularDequeGetRear(MyCircularDeque* obj) {
    if (obj == NULL) {
        return MIN;
    }
    if (isEmpty(obj)) {
        return MIN;
    }
    return obj->tail->next->val;
}

bool myCircularDequeIsEmpty(MyCircularDeque* obj) {
    if (obj == NULL) {
        return 1;
    }
    return isEmpty(obj);
}

bool myCircularDequeIsFull(MyCircularDeque* obj) {
    if (obj == NULL) {
        return 0;
    }
    return isFull(obj);
}

void myCircularDequeFree(MyCircularDeque* obj) {
    if (obj != NULL) {
        node_t *p = obj->head->next;
        while(p != obj->tail) {
            node_t * temp = p->next;
            free(p);
            p = temp;
        }
        free(obj->head);
        free(obj->tail);
        free(obj);
    }
}


/**
 * Your MyCircularDeque struct will be instantiated and called as such:
 * MyCircularDeque* obj = myCircularDequeCreate(k);
 * bool param_1 = myCircularDequeInsertFront(obj, value);
 
 * bool param_2 = myCircularDequeInsertLast(obj, value);
 
 * bool param_3 = myCircularDequeDeleteFront(obj);
 
 * bool param_4 = myCircularDequeDeleteLast(obj);
 
 * int param_5 = myCircularDequeGetFront(obj);
 
 * int param_6 = myCircularDequeGetRear(obj);
 
 * bool param_7 = myCircularDequeIsEmpty(obj);
 
 * bool param_8 = myCircularDequeIsFull(obj);
 
 * myCircularDequeFree(obj);
*/
