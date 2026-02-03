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
      component: () => import('../views/WritePage.vue'),
    },
    {
      path: '/mod/:id',
      component: () => import('../views/WritePage.vue'),
    },
    {
      path: '/detail/:id',
      component: () => import('../views/DetailPage.vue'),
    },
  ],
})

export default router
