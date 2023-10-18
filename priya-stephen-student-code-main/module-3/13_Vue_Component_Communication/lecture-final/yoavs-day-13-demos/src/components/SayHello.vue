<template>
  <div class="main-section">
      <h1>Hello! My name is 
          <span class="name-text">
              {{ name }}
            </span>
        </h1>
  </div>
</template>

<script>
export default {
    props: ['name']
}
</script>

<style scoped>
.main-section {
    padding: 10px;
}
.name-text {
    color: blue;
}
</style>