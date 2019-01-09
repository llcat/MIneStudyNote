import localforage from "localforage"

const current_user = "current_user"

let db = {
    setCurrentUser(user){
        return this.set(current_user, user)
    },

    getCurrentUser(){
        return this.get(current_user)
    },

    removeCurrentUser(){
        return this.remove(current_user)
    },

    set(key, value){
        return localforage.setItem(key, value)
    },

    get(key){
        return localforage.getItem(key)
    },

    remove(key){
        return localforage.removeItem(key)
    }
}

export default db;