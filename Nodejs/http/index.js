const fs = require("fs");
const http=require("http");//moddules
const server=http.createServer((req,res)=>{
    console.log(req.url);
    
    if(req.url=="/")
        res.end("Hello from the home sides");
    else if(req.url=="/about")
        res.end("This is my about page");
    else if(req.url=="/contact")
        res.end("This is my contact page");
    else if(req.url=="/userapi")
        fs.readFile(`${_dirname}/http/userapi.json`,"utf-8",(err,data)=>{
            console.log(data);
            res.end("This is my userapi page");
        });
    else{
        res.writeHead(404,{"Content-type":"text/html"});
        res.end("<h1>404 Error Pages</h1>");
    }
});
server.listen(8000,"127.0.0.1",()=>{
    console.log("listening")
})