import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    curPage: 1,
    editing: false,
  },
  mutations: {
    NEXT_PAGE(state) {
      state.curPage++;
    },
    PREVIOUS_PAGE(state) {
      state.curPage--;
    },
    SET_CUR_PAGE(state, pageNum) {
      state.curPage = pageNum;
    },
    SET_EDITING(state, isEditing) {
      state.editing = isEditing;
    }
  },
  // other sections
  actions: {
  },
  modules: {
  },
  // Strict should not be used in production code. It is used here as a
  // learning aid to warn you if state is modified without using a mutation.
  strict: true
})
