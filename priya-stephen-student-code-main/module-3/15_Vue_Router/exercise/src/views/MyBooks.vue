<template>
  <div>
      <reading-list/>
      <nav>
      <router-link v-bind:to="{name: 'newBook'}">Add Book to Reading List</router-link> 
      </nav>
      </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'


export default {
 
    name: "myBooks",
    components: { ReadingList}

}
</script>

<style>

</style>