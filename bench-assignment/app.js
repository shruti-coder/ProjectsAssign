const express=require("express");
const cors=require("cors");
const port =3000 || process.env.PORT;
const app=express();

const corsOptions={
    origin:"*",
    methods:["GET","PUT","POST","PATCH","DELETE","OPTIONS"],
    allowedHeaders:["Origin","X-Requested-With","Content-Type","Accept","Authorization"]
}

//connection db
require("./config/db");
require("./config/dbo");
require("./models/student");
require("./models/teacher");

//static files 
app.use(cors(corsOptions));
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use(express.static('public'));
app.use('/css',express.static(__dirname + 'public/css'));
app.use('/img',express.static(__dirname + 'public/img'));
app.use('/js',express.static(__dirname + 'public/js'));

//templating engine
app.set('views','./src/views');
app.set('view engine','ejs');

//routes
app.use(require("./src/route/index"));
app.use(require("./src/route/login"));
app.use(require("./src/route/resultmanage"));
app.use(require("./src/route/studentsearch"));
app.use(require("./src/route/teacheraddresult"));
app.use(require("./src/route/teachereditresult"));

app.listen(port);