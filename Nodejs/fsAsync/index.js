const fs=require("fs");
fs.mkdir("asyn",(err)=>{
    console.log("hello");
});
fs.writeFile("read.txt","Hello my world! ",(err)=>{
    console.log("file created");
});
fs.appendFile("read.txt","My file is being appended",(err)=>{
    console.log("appended file");
});
fs.readFile("read.txt","UTF-8",(err,ded)=>{
    console.log(ded);
})
