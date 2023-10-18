<template>
  <div id="app">
    <div class="container">
      <vue-demos />
    </div>
  </div>
</template>

<script>
import VueDemos from './components/VueDemos.vue';
export default {
  name: "App",
  components: {
    VueDemos
  },
  data() {
    return {
      names: ["Yoav", "Linda"],
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100vw;
}
</style>
