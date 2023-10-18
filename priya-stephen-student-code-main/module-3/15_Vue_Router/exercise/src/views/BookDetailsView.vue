<template>
  <div>
    <book-details v-bind:book="getBook" />
  </div>
</template>

<script>
import BookDetails from '../components/BookDetails.vue';



export default {
    name: "Home",
    components: {
        BookDetails
    },
    computed: {
      getBook(){
        let retrievedBook =
         this.$store.state.books.find((book)=> {

          return book.isbn == this.$route.params.isbn }
         )
        
          return retrievedBook;
      }
    }

}
</script>

<style>

</style>