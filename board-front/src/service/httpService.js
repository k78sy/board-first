import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080";

class HttpService {
    #url = "/board1";
  async listAll() {
    const res = await axios.get(this.#url);
    return res.data;
  }
  async oneDetail(id) {
    const res = await axios.get(`${this.#url}/${id}`);
    return res.data;
  }
  async postArticle(params) {
    const res = await axios.post(this.#url, params);
    return res.data;
  }
}
export default new HttpService();
