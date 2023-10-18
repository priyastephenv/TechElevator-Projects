<template>
  <div class="main-section">
      <h1>Hello! My name is <span class="name-text">{{ name }}</span></h1>
  </div>
</template>

<script>
export default {
    data() {
        return {
        name: 'Yoav'
        }
    }
}
</script>

<style>
.name-text {
    color: blue;
}
</style>