import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Messages from '../views/Messages.vue';
import topicdetails from '../components/TopicDetails.vue'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/:id',
    name: 'Messages',
    component: Messages
  },
  {path:'/topics/:id',
  name:'topic',
  component: topicdetails
}
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;