<script setup>
import { reactive, onMounted } from 'vue';
import httpService from '@/service/httpService';
import { useRouter } from 'vue-router';

const router = useRouter();
const state = reactive({
    list : []
})

onMounted(async () => {
    state.list = await httpService.findAll();
})

</script>

<template>
<table>
    <tr>
        <th>ID</th>
        <th>TITLE</th>
        <th>DATE</th>
    </tr>
    <tr v-for="item in state.list" :key="item.id">
        <td>{{ item.id }}</td>
        <td><router-link :to="`/detail/${item.id}`">{{ item.title }}</router-link></td>
        <td>{{ item.createdAt }}</td>
    </tr>
</table>
</template>

<style scoped>

</style>