arr=[
    {
        "name": "aa",
        "date": "2022-07-30",
        "score": 78,
        "id": 1
    },
    {
        "id": 2,
        "Name": "Student5",
        "Date": "11-10-1999",
        "Score": 88
    },
    {
        "name": "aa",
        "date": "2022-07-30",
        "score": 78,
        "id": 3
    },
    {
        "id": 4,
        "Name": "Student5",
        "Date": "11-10-1999",
        "Score": 88
    }
]
let  dob="11-10-1999";
let rollNo=4
let record;
arr.forEach((user)=>{
    if(user.id===rollNo && user.Data===dob){
   this.record=user;
    }
})

let record1=arr.filter((student)=>{student.Date===dob && student.id===rollNo})