import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    products: [],
    cart: [],
    search: '',
    curPage: 1,
    editing: false
  },
  mutations: {
      SET_PRODUCTS(state, data) {
        state.products = data;
      },
      ADD_TO_CART(state, product) {
          state.cart.push(product.product_id);
      },
      REMOVE_FROM_CART(state, product) {
          state.cart = state.cart.filter( item => {
              return item != product.product_id; 
          })
      },
      UPDATE_SEARCH(state, term) {
          state.search = term;
          state.curPage = 1;
      },
      SET_CUR_PAGE(state, pageNum) {
        state.curPage = pageNum;
      },
      SET_EDITING(state, isEditing) {
        state.editing = isEditing;
      }
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
