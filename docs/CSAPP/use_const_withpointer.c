#include<stdio.h>
int main(){
    const int i = 10;
    int* pi = &i;
    //i = 20;
    //printf("i = %d\n",i);
    //上面的赋值操作不能进行，但是我们通过一个指针完成了对一个常量的修改
    *pi = 20;
    printf("i = %d\n",i);
    return 0;
}
