const express = require("express");
const student = require("../../models/student");
const Router = express.Router();

Router.get("/addresult", async (req, res) => {
  res.render("teacheraddresult",{authUser:true});
});
Router.post("/add", (req, res) => {
  req.body.dob = new Date(req.body.dob);

  student
    .create(req.body)
    .then((result) => {
      result.save();
      res.redirect("resultmanage");
    })
    .catch((err) => {
      res.redirect("addresult");
    });
});

module.exports = Router;
