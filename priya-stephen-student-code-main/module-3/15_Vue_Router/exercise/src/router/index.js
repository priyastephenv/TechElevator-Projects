import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home'
import ReadingList from '../views/MyBooks'
import NewBook from '../views/NewBook'
import BookDetail from '../views/BookDetailsView'

Vue.use(VueRouter);

const routes = [
  { path: '/',
  name:'home',
  component: Home
  },
 {path: '/myBooks',
 name:'readingList',
component:ReadingList},
{path: '/addBook',
name:'newBook',
component:NewBook},

{path: '/book/:isbn',
name:'bookDetail',
component:BookDetail
}

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
