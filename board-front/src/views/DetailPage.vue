<script setup>
import httpService from '@/service/httpService';
import { reactive, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const state = reactive({
    detail: {
        id: 0,
        title: '',
        contents: '',
        createdAt: ''
    }
})

onMounted(async () => {
    const id = route.params.id;
    console.log(id);
    state.detail = await httpService.findOne(id);
})

const doDel = async () => {
    if(!confirm('삭제하시겠습니까?')){
        return
    }

    const params = {id:state.detail.id}
    const result = await httpService.delete(params)
    if(result){
        router.push('/')
    }
}

const doMod = () =>{
    const id = state.detail.id;
    router.push(`/mod/${id}`);
}

</script>

<template>
    <h3>Detail Page</h3>
    <main>
        <ul>
            <li>{{ state.detail.id }}</li>
            <li>{{ state.detail.title }}</li>
            <li>{{ state.detail.contents }}</li>
            <li>{{ state.detail.createdAt }}</li>
        </ul>
        <div>
            <button @click="doDel">삭제</button>
            <button @click="doMod">수정</button>
        </div>
    </main>
</template>

<style scoped></style>