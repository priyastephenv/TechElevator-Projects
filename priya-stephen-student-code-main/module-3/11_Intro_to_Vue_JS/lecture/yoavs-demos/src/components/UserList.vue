<template>
  <div class="user-container">

    <!-- Computer properties -->
    <!-- Add H3 with umber of users -->

    <div v-for="user in users" v-bind:key="user.id" class="user-item">
      User {{ user.id }} {{ user.name }}

      <!-- Add index value -->
      <!-- User {{ user.id }} (Index: {{ indexVal }}): {{ user.name }} -->
    
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      users: [
        { id: 1, name: "Yoav" },
        { id: 2, name: "Linda" },
        { id: 3, name: "Cindy" },
      ],
    };
  },
  // computed: {
  //   numOfUsers() {
  //     return this.users.length;
  //   },
  // },
};
</script>

<style scoped>
.user-container {
  text-align: left;
  padding: 10px;
  font-size: 18px;
}

.user-item {
  font-weight: bold;
}
</style>

