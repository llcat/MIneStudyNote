const CosmosClient = require('@azure/cosmos').CosmosClient

const endpoint = "https://pino-db.documents.azure.com:443/"
const masterKey = "1BuRmwSH2BzuLonOtlwkUPpRmvePML66S1xOn6EuKaZKE0E5xAGQmxmW0yNAEDBacuDIt0BBU9e09KJ0GfWPig=="

const databaseId = "testdb"
const containerId = "users"
const STATUS = {
    NOTFOUND: 404
}
const client = new CosmosClient({
    endpoint: endpoint,
    auth: {
        masterKey: masterKey
    }
})

module.exports = function (context, req) {
    context.log('--- UserLogin ---');
    let loginInfo = req.body
    context.log(loginInfo)
    let querySpec = {
        query: "SELECT * FROM users WHERE users.phone = @phone",
        parameters: [
            {
                name: "@phone",
                value: loginInfo.phone
            }
        ]
    }
    let feedOptions = {
        enableCrossPartitionQuery: true
    }
    client.database(databaseId).container(containerId).items
            .query(querySpec, feedOptions)
            .toArray()
            .then(r=>{
                let user = r.result[0]
                let res = {}
                if(user.phone===loginInfo.phone && user.password === loginInfo.password){
                    res.status = "success"
                    res.info = "验证成功"
                    res.userInfo = {
                        id: user.userId,
                        phone: user.phone,
                        nickname: user.nickname
                    }
                }else if(user.phone===loginInfo.phone && user.password !== loginInfo.password){
                    res.status = "fail"
                    res.info = "密码错误,请重新输入"
                }
                context.res = res
                context.done()
            })
            .catch(err=>{
                context.log(err)
                if (err.code === STATUS.NOTFOUND) {
                    context.res = {
                        status: "no_register",
                        info: "手机号还未注册，请先注册!"
                    }
                }
                context.done()
            })
};