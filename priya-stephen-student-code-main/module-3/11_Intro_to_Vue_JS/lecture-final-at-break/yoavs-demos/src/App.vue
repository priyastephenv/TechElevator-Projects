<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <!-- <img alt="Vue logo" v-bind:src="imgPath" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <!-- <user-list /> -->
    <vue-demos />
    <!-- <product-reviews /> -->
  </div>
</template>

<script>
import VueDemos from './components/VueDemos.vue'
// import UserList from './components/UserList.vue'
// import HelloWorld from "./components/HelloWorld.vue";
// import ProductReviews from './components/ProductReviews.vue'

export default {
  name: "app",
  components: {
    VueDemos
    // UserList
    // HelloWorld.
    // ProductReviews
  },
  data() {
    return {
      imgPath: 'https://en.wikipedia.org/wiki/Image#/media/File:Image_created_with_a_mobile_phone.png'
    }
  }
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}

</style>
