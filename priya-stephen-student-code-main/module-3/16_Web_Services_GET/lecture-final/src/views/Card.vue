<template>
  <card-detail v-bind:board-id="$route.params.boardID" :card-id="$route.params.cardID"/>
</template>

<script>
import CardDetail from '../components/CardDetail';

export default {
  components: {
    CardDetail
  }
};
</script>
