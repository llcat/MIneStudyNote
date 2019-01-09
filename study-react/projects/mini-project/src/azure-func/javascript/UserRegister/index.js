module.exports = function (context, req, users) {
    context.log("--- UserRegister ---")
    let register = req.body.data
    context.log(register)
    let exist = users.find(user=>{
        return user.phone === register.phone
    })

    if(exist){
        context.res = {
            "status": "fail",
            "info": "手机号码已注册~"
        }
        context.done()
    }else{
        context.res = {
            "status": "success",
            "info": "注册成功,请登陆"
        }
        let curDate = new Date()
        let registeredDate= `${curDate.getFullYear()}-${curDate.getMonth()+1}-${curDate.getDate()}`
        context.done(null, {
            userId: `${users.length+1}`,
            phone: register.phone,
            password: register.password,
            nickname: register.nickname,
            registeredDate: registeredDate
        })
    }
};