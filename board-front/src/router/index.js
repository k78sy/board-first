import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: () => import('../views/ListPage.vue'),
    },
    {
      path: '/write',
      component: () => import('../views/PostPage.vue'),
    },
  ],
})

export default router
