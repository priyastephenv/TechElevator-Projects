<template>
  <div>
      <div class="container">
          <img :src="imgPath" />
          <p class="caption-text">
              {{ captionText }}
          </p>
      </div>
  </div>
</template>

<script>
export default {
    props: ['imgPath', 'captionText']

}
</script>

<style scoped>
.caption-text {
    font-size: 24px;
    font-weight: bold;
}
.container {
    border: 2px solid black;
    padding: 10px;
    width: 400px;
    height: 400px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>