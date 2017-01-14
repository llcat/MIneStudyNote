#include<stdio.h>

typedef unsigned char* byte_pointer;

void show_byte(byte_pointer start,int len){
    int i;
    printf("0x");
    for(int i = 0;i<len;i++){
        printf("%.2x",start[i]);
    }
    printf("\n");
}
void show_int(int x){
    printf("show_int(%d):\n",x);
    show_byte((byte_pointer)&x,sizeof(x));
}
void show_pointer(int *x){
    printf("指针x的地址:%x\n",&x);
    printf("show_pointer:\n");
    show_byte((byte_pointer)&x,sizeof(x));
}
int main(){
    int x = 12345;
    int y = 12346;
    int *p_x = &x;
    printf("&x(x变量的首地址)为:%x\n",&x);
    printf("*p_x : %d\n",*p_x);
    printf("p_x : %x\n",p_x);
    printf("y:%d,&y:%x,*(p_x+1):%d\n",y,&y,*(p_x+1));
    printf("p_x+1:%x\n",p_x+1);
    show_int(x);
    show_int(y);
    show_pointer(&x);
    return 0;
}    

