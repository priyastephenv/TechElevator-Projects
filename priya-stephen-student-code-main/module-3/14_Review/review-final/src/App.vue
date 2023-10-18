<template>
  <div id="app">
    <header class="site-header">
      Glamazon Sellers
    </header>
    <div class="main-page">
      <product-search />
      <shopping-cart id="cart"/>
      <products-panel id="products"/>
    </div> 
    <!-- <class-demos /> -->
  </div>
</template>

<script>
// import ClassDemos from './components/ClassDemos.vue';
import ProductsPanel from './components/ProductsPanel.vue'
import ShoppingCart from './components/ShoppingCart.vue'
import ProductSearch from '@/components/ProductSearch.vue'

import productDataService from './data/amazonData';

export default {
  name: 'App',
  components: {
    // ClassDemos
    ProductsPanel,
    ShoppingCart,
    ProductSearch
  },
  created() {
    this.$store.commit('SET_PRODUCTS', productDataService.getData());
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Rock+Salt&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Acme&family=Indie+Flower&family=Montserrat:wght@200&family=Pacifico&family=Prompt&family=Rubik+Pixels&family=Signika:wght@300&display=swap');

:root {
  --mardiGras:  #822E81;
  --chinaRose: #AA6373;
  --vanilla: #F0F2A6;
  --russianViolet: #392061;
  --raisinBlack: #1A1B25;
  --olive: #aaa863;
  --russianViolet: #4E0250;
  --mardiGras2:  #801A86;
  --ultraViolet: #645986;
  --lightGreen: #8FE388;
  --emarld: #58BC82;


  /* fInal colors */
  --headerColor: var(--vanilla);
  --rowBgColor: var(--ultraViolet);
  --bgColor: var(--mardiGras2);
  --textColor: var(--vanilla);  
  --rowBorderColor: var(--russianViolet);
  --cartBgColor: var(--ultraViolet);
  --cartHeaderColor: var(--lightGreen);

}

html {
  background-color: var(--bgColor);
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  font-weight: bold;
}

.main-page {
  display: grid;
  grid-template-columns: 30% 70%;
  grid-template-areas: 
    ". search"
    "cart products";
  gap: 20px;
}

#cart {
  border: 2px solid black;
  margin-left: 20px;
  grid-area: cart;
  background-color: var(--cartBgColor);
}

#products {
  grid-area: products;
  background-color: var(--ultraViolet);
        margin-right: 20px;
}

#search {
  grid-area: search;
  justify-self: start;
}

.site-header {
  font-family: 'Rock Salt', Helvetica, Arial, sans-serif;
  font-size: 60px;
  color: var(--headerColor);
  width: 100vw;
}

</style>
