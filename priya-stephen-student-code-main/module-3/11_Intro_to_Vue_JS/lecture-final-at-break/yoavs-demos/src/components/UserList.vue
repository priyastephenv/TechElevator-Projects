<template>
  <div class="user-container">
    <!-- Computer properties -->
    <!-- Add H3 with umber of users -->
    <h3>Number of users: {{ numOfUsers }}</h3>

    <!-- <div v-for="user in users" v-bind:key="user.id" class="user-item"> -->

    <!-- use index for key instead of user.id -->
    <h4>Iterating over users</h4>
    <div
      v-for="(user, indexVal) in users"
      v-bind:key="indexVal"
      class="user-item"
    >
      User {{ user.id }} (Index: {{ indexVal }}): {{ user.name }}
    </div>

    <!-- here we are iterating over the COMPUTED property which returns a subset of data so 
          as the subset changes, the number of rows we see will change -->
    <h4>Iterating over userSubset</h4>
    <div
      v-for="(user, indexVal) in userSubset"
      v-bind:key="indexVal + 100" 
      class="user-item"
    >
      <!-- User {{ user.id }} {{ user.name }} -->

      <!-- Add index value -->
      User {{ user.id }} (Index: {{ indexVal }}): {{ user.name }}
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
        { id: 4, name: "John" },
      ],
      usersToShow: [2, 4],
      maxUsers: 2,
    };
  },
  computed: {
    numOfUsers() {
      return this.users.length;
    },
    userSubset() {
      return this.users.filter((user) => user.id <= this.maxUsers);
    },
  },
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

