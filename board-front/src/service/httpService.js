import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080"

class httpService {
    #url = "/db";

    async save(params) {
        const res = await axios.post(this.#url, params);
        return res.data;
    }

    async findAll(){
        const res = await axios.get(this.#url);
        return res.data;
    }

    async findOne(id){
        const res = await axios.get(`${this.#url}/${id}`);
        return res.data;
    }
    
    async delete(params){
        const res = await axios.delete(this.#url, {params})
        return res.data;
    }

    async modify(params){
        const res = await axios.put(this.#url, params);
        return res.data;
    }
}
export default new httpService();