<template>
  <div class="main-section">
      <h1>Hello! My name is <span class="name-text">{{ name }}</span></h1>
      <h2>Hi {{ nameExclamation }}</h2>
  </div>
</template>

<script>
export default {
    data() {
        return {
            name: 'Allison'
        }
    },
    computed: {
        nameExclamation() {
            return this.name + "!!!!!";
        }
    }
}
</script>

<style scoped>
.name-text {
    color: blue;
}
</style>