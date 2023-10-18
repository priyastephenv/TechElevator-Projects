import axios from 'axios';

// you can use this if you want to create a instance of axios that
// already has a baseURL, then you wouldn't need http://localhost:3000 as prefix
// const http = axios.create({
//   baseURL: "http://localhost:3000"
// });

export default {

  getBoards() {
    return axios.get('http://localhost:3000/boards');
  },

  getCards(boardID) {
    // return axios.get(`http://localhost:3000/boards/${boardID}}`)
    return axios.get('http://localhost:3000/boards/' + boardID);
  },

  // getCard(boardID, cardID) {
  //   return http.get(`/boards/${boardID}`).then((response) => {
  //     const cards = response.data.cards;
  //     return cards.find(card => card.id == cardID);
  //   })
  // }

}
