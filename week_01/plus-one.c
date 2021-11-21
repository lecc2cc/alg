
/**
 *   [  9, 9, 9, 9]
 *               1
 *  [1, 0, 0, 0, 0]
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    int i;
    int j=1;
    for(i=0; i <digitsSize; i++) {
        if (digits[i] != 9) {
            j=0;
            break;
        }
    }
    *returnSize = digitsSize + j;
    
    int * ret = malloc(sizeof(int) * (*returnSize));
    int k=*returnSize -1;
    j=1;
    for(i=digitsSize-1; i >= 0; i--) {
        if (j+digits[i] >= 10) {
            ret[k--] = j+digits[i] - 10;
            j=1;
        } else {
            ret[k--] = j+digits[i];
            j=0;
        }
    }
    if (j == 1) {
        ret[0]= 1;
    }

    return ret;
}
