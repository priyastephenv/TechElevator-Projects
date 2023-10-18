<template>
  <div>
    <div>
      <!-- this should display all products for current page (curPageProducts) -->
      <div id="product-row">
        <div class="product-container">
          <!-- pass the product's product_image_url as the imgUrl attribue -->
          <product-image id="img-panel" />

          <!-- pass the current product to it -->
          <product-detail id="text-panel" />
        </div>
      </div>
    </div>

    <item-pager
      :curPage="curPage"
      :maxPages="numOfPages"
      v-show="filteredProducts.length > 0"
    />
    <div class="no-items-msg" v-show="filteredProducts.length === 0">
      No items found.
    </div>
  </div>
</template>

<script>
import ItemPager from "./ItemPager.vue";
import ProductDetail from "./ProductDetail.vue";
import ProductImage from "./ProductImage.vue";
export default {
  name: "products-panel",
  components: {
    ProductImage,
    ProductDetail,
    ItemPager,
  },
  data() {
    return {
      maxItemsPerPage: 25,
    };
  },
  computed: {
    curPage() {
      return this.$store.state.curPage;
    },
    numOfPages() {
      const maxPages =
        this.filteredProducts.length > this.maxItemsPerPage
          ? this.filteredProducts.length / this.maxItemsPerPage
          : 1;
      let pagesInt = Math.floor(maxPages);
      const extra = maxPages % pagesInt;
      if (extra > 0) {
        pagesInt++;
      }
      return pagesInt;
    },
    filteredProducts() {
      /*
        modify this to return all the products
        from the store

        once search is implemented, modify this to
        implement filtering base on search
      */
      return [];
    },
    curPageProducts() {
      let prods = [];
      const start = (this.curPage - 1) * this.maxItemsPerPage;
      for (let i = start; i < start + this.maxItemsPerPage - 1; i++) {
        prods.push(this.filteredProducts[i]);
      }
      return prods;
    },
  },
  created() {
    this.$store.commit("SET_CUR_PAGE", 1);
  },
};
</script>

<style>
.product-container {
  display: grid;
  grid-template-columns: 1fr 9fr;
  grid-template-areas: "img-panel text-panel";
  border: 2px solid var(--rowBorderColor);
  border-width: 4px 4px 0 4px;
  background-color: var(--rowBgColor);
}

#img-panel {
  grid-area: img-panel;
  background-color: white;
}

#product-row:last-child div.product-container {
  border-bottom-width: 4px;
}

#text-panel {
  grid-area: text-panel;
}

.attribution {
  font-size: 10px;
}

.cat-filter {
  width: 50%;
  padding-bottom: 10px;
}
.no-items-msg {
  font-family: "Indie Flower", "Arial Narrow Bold", sans-serif;
  font-size: 36px;
  font-weight: bold;
  background-color: darkred;
  color: white;
}
</style>