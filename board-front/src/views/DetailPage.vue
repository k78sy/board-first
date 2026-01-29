<script setup>
import httpService from '@/service/httpService';
import { reactive, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const state = reactive({
    detail :{
        id:0,
        title:'',
        contents:'',
        createdAt:''
    }
})

onMounted(async() =>{
    state.detail = await httpService.oneDetail(route.params.id)
    console.log(route.params.id);
})

</script>

<template>
    <h1>디테일 페이지</h1>
    <div>
        id : {{ state.detail.id }}
    </div>
    <div>
        title :{{ state.detail.title }}
    </div>
    <div>
        content :{{ state.detail.contents }}
    </div>
    <div>
        cteatedAt :{{ state.detail.createdAt }}
    </div>
</template>

<style scoped>

</style>