const express = require('express')
const { Op } = require("sequelize");
const Router = express.Router()
const Student = require("../../models/student");

Router.get('/studentsearch', async (req, res) => {
  res.render('studentsearch', { authUser: false });
})

Router.post("/find", async (req, res) => {
  req.body.dob = new Date(req.body.dob);
  const searchR = await Student.findOne({
    where: {
      [Op.and]: [{ rollNo: req.body.rollNo }, { dob: req.body.dob }],
    },
  })
  res.render("searchresult", { result: searchR, authUser: false });
});


module.exports = Router