<template>
  <div>
    <h1>
      <!-- title of card goes here -->
    </h1>
    <p>
      <!-- description of card goes here -->
    </p>
    <div class="board-actions">
      <!-- link back to board  -->
    </div>
  </div>
</template>

<script>
export default {
  name: "card-detail",
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        comments: [],
      }
    };
  }
};
</script>
