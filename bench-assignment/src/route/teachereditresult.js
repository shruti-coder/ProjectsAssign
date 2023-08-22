const express = require("express");
const student = require("../../models/student");
const Router = express.Router();

Router.get("/editresult/:id", async (req, res) => {
  const edits = await student.findOne({ where: { id: req.params.id } });
  res.render("teachereditresult", { edit: edits ,authUser:true});
});

Router.post("/edit/:id", async (req, res) => {
  req.body.dob=new Date(req.body.dob);
  const students = await student.update(req.body, {
    where: { id: req.params.id },
  });
if(students){
    res.redirect("/resultmanage");
}
else{
    res.redirect(`editresult/${req.params.id}`);
}
});

module.exports = Router;

// req.body.id {id:"1",name:"dharmik"}
// req.param.id
// req.query.id
