<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div>
    <router-link to="/">Home</router-link>
    <router-link to="/write">Write</router-link>
  </div>
  <div>
    <router-view />
  </div>
</template>

<style scoped></style>