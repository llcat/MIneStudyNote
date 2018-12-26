var foo = true;

// bar is global
if(foo){
    var bar = foo*2;
    console.log(bar);
}

console.log(bar)

// baz is in block
if(foo){
    let baz = foo*2;
    console.log(baz);
}

// console.log(baz)

//catch has it's own block scope
try{
    throw new Error("test block scope");
}catch(err){
    console.log(err)
}

// console.log(err)

//use let will not lift up itself
{
    // console.log(cat); //reference error
    let cat = "bose";
}
//but var will lift up
{
    console.log(dog);   //undefined
    var dog = "pose";
}