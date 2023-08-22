const { DataTypes } = require("sequelize");
const sequelize = require("../config/db");

const teacherSchema = sequelize.define("teacher", {
  id: {
    type: DataTypes.INTEGER,
    allowNull: false,
    primaryKey: true,
    autoIncrement: true,
  },
  email: {
    type: DataTypes.STRING,
    allowNull: false,
    required: true,
    unique: {
      msg: "Email already Exist",
    }
  },
  password:{
    type: DataTypes.STRING,
    allowNull: false,
    required: true
  }
});

module.exports = teacherSchema;
