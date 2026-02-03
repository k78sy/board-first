<script setup>
import httpService from '@/service/httpService';
import { onMounted, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const state = reactive({
    list: []
})

onMounted(async () => {
    state.list = await httpService.list();
})
const goDetail = (id) =>{
    router.push(`/detail/${id}`)

}
</script>

<template>
    <h3>List Page</h3>
    <div v-if="!state.list.length">게시글이 없습니다.</div>
    <table v-else>
        <thead>
            <tr>
                <th>NO</th>
                <th>TITLE</th>
                <th>DATE</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in state.list" :key="item.id" @click="goDetail(item.id)">
                <td>{{ item.id }}</td>
                <td>{{ item.title }}</td>
                <td>{{ item.createdAt }}</td>
            </tr>
        </tbody>
    </table>

</template>

<style scoped></style>