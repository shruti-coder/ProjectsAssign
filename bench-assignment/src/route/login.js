const express = require("express");
const { Op } = require("sequelize");
const Router = express.Router();
const Teacher = require("../../models/teacher");

Router.get("/login", async (req, res) => {
  res.render("login",{authUser:false});
});
Router.get("/signup", async (req, res) => {
  res.render("signup",{authUser:false});
});

Router.post("/getSignup", (req, res) => {
  Teacher.create(req.body)
    .then((result) => {
      result.save();
      // res.status(201).json({ msg: "User created Successfully" });
      res.redirect("/login")
    })
    .catch((err) => {
      // res.status(500).json({ err: err.errors[0].message });
      res.redirect("/signup")
    });
});

Router.post("/getLogin", (req, res) => {
  Teacher.findOne({
    where: {
      [Op.and]: [{ email: req.body.email }, { password: req.body.password }],
    },
  })
    .then((result) => {
        console.log(result)
      if (result!==null) res.redirect("resultmanage");
      else res.redirect("login")
    })
    .catch(() => {
      res.redirect("login");
    });
});

module.exports = Router;
