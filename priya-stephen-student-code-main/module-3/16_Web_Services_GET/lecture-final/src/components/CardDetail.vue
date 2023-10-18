<template>
  <div>
    <!-- <div class="loading" v-if="isLoading"> -->
    <div class="loading" v-show="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <!-- <div v-else> -->
    <!-- <div v-if="!isLoading"> -->
    <div v-show="!isLoading">
      <h1>
        <!-- title of card goes here -->
        {{ card.title }}
      </h1>
      <p>
        <!-- description of card goes here -->
        {{ card.description }}
      </p>
    </div>
      <comments-list v-bind:comments="card.comments" v-show="!isLoading"/>
    <div class="board-actions">
      <!-- link back to board  -->
      <router-link :to="{ name: 'Board', params: { id: BoardId}}" v-show="!isLoading">
        Back to Board
      </router-link>
    </div>
  </div>
</template>

<script>
import boardService from "../services/BoardService";
import CommentsList from "./CommentsList.vue";
export default {
  name: "card-detail",
  props: ["BoardId", "CardId"],
  components: { CommentsList },
  data() {
    return {
      card: {
        title: "WAITING",
        description: "",
        status: "",
        comments: [],
      },
      isLoading: true,
    };
  },
  created() {
    boardService.getCards(this.BoardId).then((resp) => {
      // get the board data from the rsponse
      const board = resp.data;

      // get the cards property from the board
      const cards = board.cards;
      this.card = cards.find((card) => card.id == this.CardId);
      this.isLoading = false;
    });
  },
};
</script>
