<template>
  <div>
      <tr class="table-row-container" :class="{ favorited: review.favorited }">
          <td>
              {{ review.title }}
          </td>
          <td>
              {{ review.reviewer }}
          </td>
          <td>
              {{ review.review }}
          </td>
          <td class="stars">
              <img src="../assets/star.png" v-for="ratingVal in review.rating" :key="ratingVal"
                v-bind:title="review.rating + ' star review'"
                class="star"
                width="20px"
              />
          </td>
          <td>
                <input id="fav-check" type="checkbox" :checked="review.favorited"
                    @change="onFavoriteChange"/>
          </td>
      </tr>
  </div>
</template>

<script>
export default {
    props: ['review'],
    methods: {
        onFavoriteChange() {
            this.$store.commit('FLIP_FAVORITED', this.review)
        }
    }

}
</script>

<style scoped>
.table-row-container {
    width: 100%;
}
.stars {
  display: flex;
}

.favorited {
  background-color: lightyellow;
}
</style>