function baz(){
    console.log("baz");
    bar();
}

function bar(){
    console.log("bar");
    foo();
}

function foo(){
    // debugger
    console.log("foo")
}

// plaese see call stack in devtools
baz()

function loc1(){
    for(let i=5;i<8;i++){
        loc2()
    }
}

loc1.count=0;
global.count=0;

function loc2(){
    this.count++;
}

loc1();
console.log(loc1.count)
console.log(global.count)