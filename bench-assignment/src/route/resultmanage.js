const express = require('express')
const student=require("../../models/student")
const Router = express.Router()

Router.get('/resultmanage',async(req, res) => {
   const students=await student.findAll();
 res.render("resultmanage" ,{authUser:true,students:students,noOfStudents:students.length});
})

Router.get('/delete',async(req, res) => {
    const deleted = await student.destroy({where :{ id :req.query.id}});
    res.redirect("resultmanage")
})


module.exports = Router