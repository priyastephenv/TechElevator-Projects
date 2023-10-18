<template>
  <div>
    <div class="pager-container">
      <!-- <span v-show="curPage > 1" @click="prevPage"><i class="fas fa-caret-left" ></i></span> -->
      <span @click="prevPage"><i class="fas fa-caret-left"></i></span>
      Page
      <span v-show="!editing" @click="toggleEdit(true)">{{ curPage }}</span>
      <span v-show="editing"
        ><input
          type="number"
          v-model.number="pageNumEdit"
          class="edit-box"
          @blur="toggleEdit(false)"
          @keyup.enter="toggleEdit(false)"
      /></span>
      of {{ Math.trunc(maxPages) }}
      <span v-show="curPage < maxPages" @click="nextPage()"
        ><i class="fa-solid fa-caret-right"></i
      ></span>
    </div>
  </div>
</template>

<script>
export default {
  props: ["maxPages"],
  data() {
    return {
      pageNumEdit: 1,
    };
  },
  computed: {
    curPage() {
      return this.$store.state.curPage;
    },
    editing() {
      return this.$store.state.editing;
    },
  },
  methods: {
    nextPage() {
      if (!this.editing && this.curPage < this.maxPages) {
        // this.$store.commit("SET_CUR_PAGE", parseInt(this.curPage) + 1);
        this.$store.commit('NEXT_PAGE');
        // this.$store.state.curPage++
      }
    },
    prevPage() {
      if (!this.editing && this.curPage > 1) {
        // this.$store.commit("SET_CUR_PAGE", parseInt(this.curPage) - 1);
        this.$store.commit('PREVIOUS_PAGE');
      }
    },
    toggleEdit(showEdit) {
      if (showEdit) {
        this.pageNumEdit = this.curPage;
        this.$store.commit("SET_EDITING", true);
      } else {
        if (this.pageNumEdit > 0 && this.pageNumEdit <= this.maxPages) {
          this.$store.commit("SET_CUR_PAGE", this.pageNumEdit);
        }
        this.$store.commit("SET_EDITING", false);
      }
    },
  },
  created() {
      this.$store.commit("SET_CUR_PAGE", this.pageNumEdit);
  }
};
</script>

<style scoped>
.pager-container {
  font-size: 24px;
  margin-top: 10px;
  margin-bottom: 10px;
  width: 100%;
}
.edit-box {
  font-size: 24px;
  max-width: 100px;
  text-align: center;
}
</style>