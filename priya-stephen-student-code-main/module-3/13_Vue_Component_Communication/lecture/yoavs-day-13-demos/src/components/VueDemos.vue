<template>
  <div>
    <div class="main-container">
      <div class="demo-container reactivity-demo-container">
        <div class="demo-header">
          <span class="toggle-symbol" @click="showReactivityDemo = !showReactivityDemo">
            {{ showReactivityDemo ? "-" : "+" }}</span>
          <span class="toggle-text">Reactivity Demo</span>
          <reactivity-demo  v-show="showReactivityDemo" />
        </div>
      </div>
      <div class="demo-container say-hello-container">
        <div>
          <span class="toggle-symbol" @click="showSayHello = !showSayHello">{{
            showSayHello ? "-" : "+"
          }}</span>
          <span class="toggle-text">Say Hello</span>
        </div>
        <say-hello v-show="showSayHello" 
          v-for="(curName, index) in names"
          :key="index"
          :name="curName" />
      </div>
      <div class="demo-container paging-container">
        <div>
          <span class="toggle-symbol" @click="showPaging = !showPaging">{{
            showPaging ? "-" : "+"
          }}</span>
          <span class="toggle-text">Page with Pager</span>
        </div>
        <page-info v-show="showPaging"/>
        <pager-tool maxPages="100" v-show="showPaging"/>
      </div>
      <div class="demo-container img-list-container">
        <div>
          <span class="toggle-symbol" @click="showImageList = !showImageList">{{
            showImageList ? "-" : "+"
          }}</span>
          <span class="toggle-text">Image List</span>
        </div>
        <image-list v-show="showImageList" />
      </div>
    </div>
  </div>
</template>

<script>
import SayHello from "./SayHello.vue";
import PageInfo from "./PageInfo.vue";
import PagerTool from "./PagerTool.vue";
import ImageList from "./ImageList.vue";
import ReactivityDemo from './ReactivityDemo.vue';
export default {
  components: {
    SayHello,
    PageInfo,
    PagerTool,
    ImageList,
    ReactivityDemo,
  },
  data() {
    return {
      showReactivityDemo: false,
      showSayHello: false,
      showPaging: false,
      showImageList: false,
      names: [
        'Yoav',
        'Linda'
      ]
    };
  },
};
</script>

<style scoped>
.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.demo-container {
  width: 70vw;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  border: 2px solid black;
  margin: 5px;
  padding: 10px;
}

.demo-header {
  text-align: start;
}

.toggle-text {
  font-size: 20px;
  font-weight: bold;
  margin-left: 5px;
}
.toggle-symbol {
  font-size: 26px;
}

.toggle-symbol:hover {
  cursor: pointer;
}

.v-model-demo {
  padding: 10px;
}
</style>