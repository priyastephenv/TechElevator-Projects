<template>
  <div>
    <div class="pager-container">
      <span v-show="curPage > 1" @click="prevPage"><i class="fas fa-caret-left" ></i></span>
      Page 
      <span v-show="!editing" @click="toggleEdit(true)">{{ curPage }}</span>
      <span v-show="editing"><input type="number" v-model.number="pageNumEdit" class="edit-box" @blur="toggleEdit(false)" @keyup.enter="toggleEdit(false)"/></span> of {{ Math.trunc(maxPages) }}
      <span v-show="curPage < maxPages"   @click="nextPage()"><i class="fa-solid fa-caret-right" ></i></span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'item-pager',
  props: ["curPage", "maxPages"],
  data() {
    return {
      pageNumEdit: 1
    }
  },
  computed: {
    editing() {
      return this.$store.state.editing;
    }

  },
  methods: {
      nextPage() {
          if (!this.editing && this.curPage < this.maxPages) {
            this.$store.commit('SET_CUR_PAGE', this.curPage + 1)
          }
      },
      prevPage() {
          if (!this.editing && this.curPage > 1) {
              this.$store.commit('SET_CUR_PAGE', this.curPage - 1)
          }
      },
      toggleEdit(showEdit) {
        if (showEdit) {
          this.pageNumEdit = this.curPage;
          this.$store.commit('SET_EDITING', true)
        } else {
          if (this.pageNumEdit > 0 && this.pageNumEdit <= this.maxPages) {
            this.$store.commit('SET_CUR_PAGE', this.pageNumEdit)
          }
          this.$store.commit('SET_EDITING', false)
        }
      }
  }
};
</script>

<style scoped>
.pager-container {
    font-size: 24px;
    color: white;
    background-color: var(--ultraViolet);
    margin-left: 30%;
    margin-right: 30%;
    margin-top: 10px;
    margin-bottom: 10px;

}
.edit-box {
  font-size: 24px;
  max-width: 100px;
  text-align: center;
}
</style>