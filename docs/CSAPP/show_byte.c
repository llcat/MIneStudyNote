#include<stdio.h>

typedef unsigned char* byte_pointer;

void show_byte(byte_pointer start,int len){
    int i;
    for(int i = 0;i<len;i++){
        printf("%.2x",start[i]);
    }
    printf("\n");
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
    return 0;
}    

