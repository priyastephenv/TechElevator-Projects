<template>
    <div id="main-container">
        <div id="panel">
            <div id="product-name">
                <!-- replace with actual product name -->
                {{ product.product_name  }}
            </div>
           
            <div id="rating-price"> 
                <!-- modify this so it creates as many stars as intRating returns -->
                <div v-for="star in intRating " :key="star">
                    <img class="rating-star" src="../assets/star-symbol.png" />
                </div>
                <div v-show="showHalfStar">
                    <!-- modify this so that it is only shown if we need a half star (the showHalfStar
                        computed property indicates this) -->
                    <img class="rating-star" src="../assets/star-half-yellow.png" />
                </div>

                <!-- product price goes here -->
                <!-- only show this is if price available (product_price will be '' if there is no price) -->
                <div id="price" v-show="hasPrice">
                    $ {{ product.product_price }}
                </div>

                <!-- show this section if there is no price is available (product_price will be '' if there is no price) -->
                <div id="no-price" v-show="!hasPrice">
                    No price information available.
                </div>
            </div>

            <!-- if item not in cart, show add to cart button -->
            <div class="add-to-cart" v-show="!inCart">
                <!-- clicking on button should add the item to the cart -->
                <!-- this button should be disabled if price is not available -->
                <!-- if the button is disabled, cart-button-disabled style should be applied -->
                <button  class="cart-button" v-bind:disabled="!hasPrice"
                    v-bind:class="{  'cart-button-disabled': !hasPrice  }"
                    @click="addToCart">
                    <i class="fas fa-cart-plus"></i>
                </button>
            </div>
            <!-- if item already in cart show this message -->
            <div class="in-cart" v-show="inCart">
                Already in cart
            </div>
        </div>
  </div>
</template>

<script>
export default {
    name: 'product-detail',
    props: ['product'],
    computed: {
        intRating() {
            return parseInt(this.product.product_rating);
        },
        showHalfStar() {
            return (this.product.product_rating - this.intRating) >= .5;
        },
        inCart() {
            /* check if item is in cart. note that cart currently only
                stores product id */

            /* placeholder - should return correct value*/
            const cart =this.$store.state.cart;
            const id = this.product.product_id;

            return cart.includes(id);
        },
        hasPrice() {
            return this.product.product_price !== '';
        }
    },
    methods: {
        addToCart() {
            this.$store.commit('ADD_TO_CART', this.product)
        }
    }
}
</script>

<style scoped>

    #panel {
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        margin-top: 20px;
        margin-left: 10px;
        color: var(--textColor);
    }

    #product-name {
        font-family: 'Indie Flower', 'Arial Narrow Bold', sans-serif;
        font-weight: bold;
        font-size: 18px;
        text-align: left;
    }

    #price {
        font-family: 'Indie Flower', 'Arial Narrow Bold', sans-serif;
        font-size: 18px;
        text-align: left;
        margin-left: 20px;
        margin-top: auto;
        margin-bottom: auto;
    }

    #no-rating, #no-price{
        margin-top: auto;
        margin-bottom: auto;
        color: #ff6666;
        margin-left: 10px;
        font-weight: bold;
    }

    #rating-price {
        margin-top: 20px;
        display: flex;
        font-weight: bold;
    }

    .rating-star {
        width: 30px;
        height: auto;
        align-self: top;
    }

    .add-to-cart, .in-cart {
        font-size: 28px;
        text-align: right;
        padding-top: 20px;

        padding-right: 40px;
        color: blue;
    }

    .in-cart {
        font-size: 20px;
        margin-top: 10px;
        color: #ff6666;
    }

    .cart-button {
        background-color: var(--ultravIolet);
        color: var(--lightGreen);
        border: none;
    }


    .cart-button:hover {
        border: 1px solid var(--lightGreen);
    }

    .cart-button-disabled {
        background-color: gray;
        color: lightgray
    }

    .cart-button-disabled:hover {
        border: none;
    }

</style>