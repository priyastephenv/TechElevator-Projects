<template>
    <div>
        <div class="container">
            <header>
                <h1 class="cart-header">Items in cart:</h1>
            </header>

            <main>
                <div class="items">
                        <!-- display all the items in the cart  (use cartItems computed prop) -->
                        <div class="item" >
                            <!-- this should remove the item from the cart (put the event on the span)-->
                            <span class="remove"><i class="fas fa-trash-alt"></i></span>
                            
                            <span class="product-img">
                                <!-- uncomment this, the wire up src to use the product_image_url 
                                    of the current product -->
                                <!-- <img class="item-img" src="" /> -->
                            </span>
                            
                            <!-- add the product name -->
                            <span class="product-name">Product Name</span>
                            
                            <!-- add the product price -->
                            <span class="product-price">$ Product Price</span>
                        </div>
                        <cart-total class="total"/>
                </div>
            </main>
        </div>
    </div>
</template>

<script>
import CartTotal from './CartTotal.vue';
export default {
  components: { CartTotal },
    name: 'shopping-cart',
    computed: {
        cartItems() {
            const cart = this.$store.state.cart;
            return this.$store.state.products.filter( product => {
                return cart.includes(product.product_id);
            });
        }
    },
    methods: {
        removeFromCart(productToRemove) {
            this.$store.commit('REMOVE_FROM_CART', productToRemove);
        } 
    }
}
</script>

<style scoped>
    .container {
        height: 100vh;
        text-align: left;
        padding: 0px 20px;
    }

    .cart-header {
        color: var(--vanilla);
    }

    
    .item {
        padding-bottom: 10px;
        font-weight: bold;
        display: grid;
        grid-template-columns: 10% 1fr 4fr 20%;
        grid-template-areas: 
            "remove  product-img product-name product-price"
            "total total total total";
        column-gap: 10px;
        align-items: center;
        color: #d6a6f2;
        
    }

    .product-img {
        grid-area: product-img;
        height: 50px;
        width: 50px;
    }

    .item-img {
        max-width: 100%;
        max-height: 100%;
    }

    .product-name {
        font-size: 12px;
        grid-area: product-name;
    }

    .remove {
        text-align: center;
        color: #ff6666;
    }

    .remove:hover {
        border: 1px solid red;
    }

    .product-price {
        grid-area: product-price;
    }

    .total {
        grid-area: total;
    }
    
</style>