import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080";

class httpService {
  #url = "/board_db";
  async save(params) {
    const res = await axios.post(this.#url, params);
    return res.data;
  }
  async list() {
    const res = await axios.get(this.#url);
    return res.data;
  }
  async detail(id) {
    const res = await axios.get(`${this.#url}/${id}`);
    return res.data;
  }
  async delete(params) {
    const res = await axios.delete(this.#url, { params });
    return res.data;
  }
  async update(id){
    const res = await axios.put(this.#url, id);
    return res.data;
  }
}
export default new httpService();
