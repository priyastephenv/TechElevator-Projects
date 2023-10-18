<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <!-- <user-list /> -->
    <vue-demos />
  </div>
</template>

<script>
import VueDemos from './components/VueDemos.vue'
// import UserList from './components/UserList.vue'
// import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "app",
  components: {
    VueDemos
    // UserList
    // HelloWorld
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
  margin-top: 60px;
}
</style>
