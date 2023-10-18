<template>
  <div>
      <div class="images">
          <div class="image" v-for="(img, imgIndex) in imgs" :key="imgIndex">
            <image-with-caption 
                :img-path="img.url"
                :caption-text="img.caption"/>
          </div>
      </div>
  </div>
</template>

<script>
import ImageWithCaption from './ImageWithCaption.vue';
export default {
  components: { ImageWithCaption },
  data() {
    return {
      imgs: [
          { 
              url: "https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/182px-Java_programming_language_logo.svg.png",
              caption: 'Java is for Back Ends'
          },
          {
            url: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Postgresql_elephant.svg/180px-Postgresql_elephant.svg.png",
            caption: 'PostgreSQL is for Data'
          },
          {
            url: "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Vue.js_Logo_2.svg/180px-Vue.js_Logo_2.svg.png",
            caption: 'Vue.js is for Front Ends'
          }
      ],
    };
  },
};
</script>

<style scoped>
.images {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>