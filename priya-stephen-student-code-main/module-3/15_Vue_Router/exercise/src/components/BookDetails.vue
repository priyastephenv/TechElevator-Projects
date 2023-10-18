<template>
  <div>
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    
  </div>
</template>

<script>
export default {
  name: "book-detail",
  props: {book: Object}

}
</script>

<style>

</style>