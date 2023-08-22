const { DataTypes } = require("sequelize");
const sequelize = require("../config/db");

const studentSchema = sequelize.define("student", {
  id: {
    type: DataTypes.INTEGER,
    allowNull: false,
    primaryKey: true,
    autoIncrement: true,
  },
  rollNo: {
    type: DataTypes.INTEGER,
    allowNull: false,
    required: true,
    unique: {
      msg: "Roll No. Should be Unique",
    },
  },
  name: {
    type: DataTypes.STRING,
    allowNull: false,
    required: true
  },
  dob: {
    type: DataTypes.DATE,
    allowNull: false,
    required: true,
  },
  score: {
    type: DataTypes.INTEGER,
    allowNull: false,
    required: true
  },
});

module.exports = studentSchema;
