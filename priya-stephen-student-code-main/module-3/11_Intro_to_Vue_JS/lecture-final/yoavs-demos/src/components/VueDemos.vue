<template>
  <div>
    <div class="main-container">
      <div class="demo-container say-hello-container">
        <div>
          <span class="toggle-symbol" @click="showSayHello = !showSayHello">{{
            showSayHello ? "-" : "+"
          }}</span>
          <span class="toggle-text">SayHello</span>
        </div>
        <say-hello v-show="showSayHello" />
      </div>
      <div class="demo-container user-list-container">
        <div>
          <span class="toggle-symbol" @click="showUserList = !showUserList">{{
            showUserList ? "-" : "+"
          }}</span>
          <span class="toggle-text">UserList</span>
        </div>
        <user-list v-show="showUserList" />
      </div>
      <div class="demo-container v-model-demo-container">
        <div>
          <span
            class="toggle-symbol"
            @click="showVModelDemo = !showVModelDemo"
            >{{ showVModelDemo ? "-" : "+" }}</span
          >
          <span class="toggle-text">VModelDemo</span>
        </div>
        <v-model-demo class="v-model-demo" v-show="showVModelDemo" />
      </div>
      <div class="demo-container v-model-checkboxes-container">
        <div>
          <span
            class="toggle-symbol"
            @click="showVModelWithCheckboxes = !showVModelWithCheckboxes"
            >{{ showVModelWithCheckboxes ? "-" : "+" }}</span
          >
          <span class="toggle-text">VModelWithCheckboxes</span>
        </div>
        <v-model-with-checkboxes v-show="showVModelWithCheckboxes" />
      </div>
    </div>
  </div>
</template>

<script>
import SayHello from "./SayHello.vue";
import UserList from "./UserList.vue";
import VModelDemo from "./VModelDemo.vue";
import VModelWithCheckboxes from "./VModelWithCheckboxes.vue";
export default {
  components: {
    SayHello,
    UserList,
    VModelDemo,
    VModelWithCheckboxes,
  },
  data() {
    return {
      showSayHello: false,
      showUserList: false,
      showVModelDemo: false,
      showVModelWithCheckboxes: false,
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