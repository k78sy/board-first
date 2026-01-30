import axios from "axios";
axios.defaults.baseURL = "http://localhost:8080";

class httpService {
  async save(params) {
    const res = await axios.post("/db", params);
    return res.data;
  }
  async findLIst() {
    const res = await axios.get("/db");
    return res.data;
  }
  async findOne(id) {
    const res = await axios.get(`/db/${id}`);
    return res.data;
  }
  async delete(params) {
    const res = await axios.delete("/db", { params });
    return res.data;
  }
  async modify(params){
    const res = await axios.put("/db", params);
    return res.data;
  }
}

export default new httpService();
