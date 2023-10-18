<template>
  <table>
    <thead>
      <tr v-show="filteredReviews.length !== 0">
        <th>Title</th>
        <th>Reviewer</th>
        <th>Review</th>
        <th>Rating</th>
        <th>Favorited</th>
      </tr>
    </thead>
    <tbody>
      <!-- add a table row for each review (show rows filtered by rating) -->
      
      <review-table-row v-for="review in filteredReviews" v-bind:key="review.id" v-bind:review="review" 
        v-show="filteredReviews.length !== 0"/>

      <!-- if there are NO reviews, show this instead -->

      <tr >
        <td colspan="5" v-show="filteredReviews.length === 0">There are no reviews</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ReviewTableRow from './ReviewTableRow.vue';

export default {
  components: { ReviewTableRow },
  name: "review-table",
  computed: {
    filteredReviews() {
      const reviewsFilter = this.$store.state.filter;
      const reviews = this.$store.state.reviews;
      return reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
  }
  }
}
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
