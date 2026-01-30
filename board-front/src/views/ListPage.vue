<script setup>
import { reactive, onMounted } from 'vue';
// import { useRouter } from 'vue-router';
import httpService from '@/service/httpService';

// const router = useRouter();

const state = reactive({
    list :[

    ]
})


onMounted(async() =>{
    state.list = await httpService.findLIst();
})


</script>

<template>
<h3>List Page</h3>

<main>
    <ul>
        <li v-for="item in state.list " :key="item.id">
            <p>{{ item.id }}</p>
            <router-link :to="`/detail/${item.id}`"><p>{{ item.title }}</p></router-link>
            <p>{{ item.createdAt }}</p>
        </li>
    </ul>
</main>
</template>

<style scoped>

</style>