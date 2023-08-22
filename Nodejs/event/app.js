// const index = require("./index");
// console.log(index.Sum(1,1));
// console.log(index.PI);
// console.log(new index.SomeMathObject);
// // console.log(index(1,1));
const readline=require('readline');
const rl=readline.createInterface({input :process.stdin,
                                   output :process.stdout});
let num1=Math.floor((Math.random()*10)+1);
let num2=Math.floor((Math.random()*10)+1);
let ans=num1+num2;
rl.question(`What is ${num1} +${num2} ?\n`,
(userInput)=>{
        if(userInput.trim()==ans){
            rl.close();
            // console.log(userInput);
        }
});