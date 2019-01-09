import axios from 'axios'
import md5 from 'blueimp-md5'

let functionApi = {
    baseUrl: "https://pino-func.azurewebsites.net",

    getUploadUrl(blobname,filename){
        let config = {
            params: {
                blobname,
                filename
            }
        }
        return axios.get(`${this.baseUrl}/api/GetUploadUrl`, config)
        .then(rep=>{
            return rep.data.url
        })
    },

    UserRegister(register){
        let url = `${this.baseUrl}/api/UserRegister`
        let config = {
            data: {
                phone: register.phone.value,
                password: md5(register.password.value),
                nickname: register.nickname.value
            }
        }
        return axios.post(url, config)
    },

    UserLogin(user){
        let url = `${this.baseUrl}/api/UserLogin`
        let config = {
            data: {
                phone: user.phone,
                password: md5(user.password)
            }
        }
        return axios.post(url, config)
    }
}

let blobApi = {
    baseUrl: "https://pinoblob.blob.core.windows.net",
}

export default functionApi;