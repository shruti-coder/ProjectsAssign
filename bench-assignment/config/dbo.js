const sequelize=require("./db");

module.exports=(async()=>{
    await sequelize.sync();
})();