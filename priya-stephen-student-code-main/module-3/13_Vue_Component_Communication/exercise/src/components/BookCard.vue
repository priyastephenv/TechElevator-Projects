<template>
  <div class="card" v-bind:class="{ read:book.read}">
      <h2 class="book-title">{{book.title}}</h2>
      <img v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" alt= "Book Cover" class="book-image"/>
      <h3 class="book-author">{{book.author}}</h3>
        <button class="mark-unread" v-on:click.prevent="setRead(false)" v-show="book.read">Mark Unread</button>
        <button class="mark-read" v-on:click.prevent="setRead(true)" v-show="!book.read">Mark Read</button>
        
  </div>
</template>
<script>
    export default {
        name: 'book-card',
        props: {
            book:  Object,
        
        },
        methods: {
           setRead(value) {
            this.$store.commit('SET_READ_STATUS', {book:this.book,value:value});
        },
    
        },
    };
</script>
<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}
.card.read {
    background-color: lightgray;
}
.card .book-title {
    font-size: 1.5rem;
}
.card .book-author {
    font-size: 1rem;
}
.book-image {
    width: 80%;
}
.mark-read, .mark-unread {
    display: block;
    position: absolute;
    bottom: 40px;
    width: 80%;
    left: 10%;
    font-size: 1rem;
}
</style>