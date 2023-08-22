// const sum=(num1,num2)=>num1+num2;
// const Pi=3.14;
// class SomeMathObject{
//     constructor(){
//         console.log("object created");
//     }
// }
// module.exports.sum=sum;
// module.exports.Pi=Pi;
// module.exports.SomeMathObject=SomeMathObject;
// // module.exports={Sum:sum,PI:Pi,SomeMathObject}
// const EventEmitter=require('events');
// const eventEmitter=new EventEmitter();
// eventEmitter.on('app',()=>{
//     console.log('tutorial event has occcuered');
// }); 
// const http=require('http');
// const data=require('./data')
// // const { listenerCount } = require('process');
// http.createServer((req,resp)=>{
//     resp.writeHead(202,{'Content-Type':'application\json'});
//     resp.write(JSON.stringify(data));
//     resp.end();
// }).listen(5000);
// const fs=require ('fs');
// const path=require('path');
// const dirPath=path.join(__dirname,'event');
// const filePath=`${dirPath}/apple.txt`;
// fs.readFile(filePath,(err,item)=>{
//     console.log(item);
// })

const { dir } = require('console');
const fs=require('fs');
const path=require('path');
const dirPath=path.join(__dirname,'files');
// console.warn(dirPath);
for(i=0;i<5;i++)
{
    fs.writeFileSync(dirPath+"/hello"+i+".txt","a simple file");
}