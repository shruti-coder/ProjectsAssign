const Sequelize = require("sequelize");

const options = {
  host: "localhost",
  dialect: "mysql",
  operatorAliases: false,
};

const sequelize = new Sequelize("rms", "root", "root", options);

sequelize.authenticate()
  .then(() => {
    console.log("Connection has been established successfully.");
  })
  .catch((err) => {
    console.log("Error:"+err);
  });

  module.exports=sequelize;
  global.sequelize=sequelize;
