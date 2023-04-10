import { createRouter, createWebHistory } from 'vue-router'
import Index from '../components/IndexView.vue'
import Home from '../components/HomeView.vue'
import Group from '../views/GroupView.vue'
import Login from '../views/UserLoginView.vue'
import Category from '../views/CategoryView.vue'
import Signup from '../views/UserSignupView.vue'
import Post from '../views/PostView.vue'
import CreatePost from '../views/CreatePostView.vue'
import CreateGroup from '../views/CreateGroupView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      children:[{
        path: '',
        name:'homepage',
        component: Home
      },
      {
        path: '/home',
        name: 'home',
        component: Home
      },
      {
        path: '/login',
        name: 'login',
        component: Login
      },
      {
        path: '/signup',
        name: 'signup',
        component: Signup
      },
      {
        path: '/group',
        name: 'group',
        component: Group
      },
      {
        path: '/category',
        name: 'category',
        component: Category
      },{
        path: '/post', 
        name: 'post', 
        component: Post
      },{
        path: '/createpost', 
        name: 'createpost', 
        component: CreatePost
      },{
        path: '/creategroup', 
        name: 'creategroup', 
        component: CreateGroup
      }
      ]
    }
  ]
})

export default router
