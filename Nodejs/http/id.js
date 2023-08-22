const fs=require("fs")
const bioData={
    name:"Shruti",
    age:22,
    city:"pbt"
};
console.log(bioData.city);
const jsonData=JSON.stringify(bioData);
console.log(jsonData);
fs.writeFile("json.json",jsonData,(err)=>{
    console.log("hello");
})
const objData=JSON.parse(jsonData);
console.log(objData)
