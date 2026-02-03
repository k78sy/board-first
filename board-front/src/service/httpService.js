import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080";

class httpSevice{
    #url = '/board_db';
    async save(jsonBody){
        const res = await axios.post(this.#url, jsonBody);
        return res.data;
    }
    async list(){
        const res = await axios.get(this.#url);
        return res.data;
    }
    async detail(id){
        const res = await axios.get(`${this.#url}/${id}`);
        return res.data;
    }
    async del(params){
        const res = await axios.delete(this.#url, {params});
        return res.data;
    }
    async mod(jsonBody){
        const res = await axios.put(this.#url, jsonBody);
        return res.data;
    }

}
export default new httpSevice();