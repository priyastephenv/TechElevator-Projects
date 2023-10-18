import Vue from 'vue'
import VueRouter from 'vue-router'

import Products from '../views/Products'
import ProductDetail from '../views/ProductDetail'
import AddNewReview from '../views/AddNewReview'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:productId',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/add-review/:id',
    name: 'add-new-review',
    component: AddNewReview
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
