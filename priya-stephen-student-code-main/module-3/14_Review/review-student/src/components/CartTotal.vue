<template>
  <div class="total">
    <!-- add the total cost here -->
    Total: $Total Cost
  </div>
</template>

<script>
export default {
  name: "cart-total",
  computed: {
    totalCost() {
      /*  transform the cartItems (use the computed property below) to an array of their product_prices 
                assign the result to the prices variable */
      const prices = [0];

      let sum = 0;
      prices.forEach((price) => (sum += parseFloat(price)));
      return sum.toFixed(2);
    },
    cartItems() {
      const cart = this.$store.state.cart;
      return this.$store.state.products.filter((product) => {
        return cart.includes(product.product_id);
      });
    },
  },
};
</script>

<style>
.total {
  text-align: right;
  color: var(--vanilla);
}
</style>