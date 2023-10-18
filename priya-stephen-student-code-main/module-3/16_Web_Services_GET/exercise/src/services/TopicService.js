import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },
  listSpecific(id) {
    return http.get(`/topics/${id}`);
  }
 
}
