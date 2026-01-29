<script setup>
import { reactive, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import httpService from '@/service/httpService';

const state = reactive({
    list:[]
})

onMounted(async() =>{
    state.list = await httpService.listAll();
    console.log(state.list);
})
</script>

<template>
<h3>List Page</h3>
<div>
    <table>
        <tr>
            <th>no</th>
            <th>title</th>
            <th>date</th>
        </tr>
        <tr v-for="item in state.list" :key="item.id">
            <td>{{ item.id }}</td>
            <td><router-link :to="`/detail/${item.id}`">{{ item.title }}</router-link></td>
            <!-- <td>{{ item.title }}</td> -->
            <td>{{ item.createdAt }}</td>
        </tr>
    </table>
</div>


</template>

<style scoped>

</style>