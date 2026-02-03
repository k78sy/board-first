<script setup>
import httpService from '@/service/httpService';
import { onMounted, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const state = reactive({
    data: {
        id: 0,
        title: '',
        contents: '',
        createdAt: ''
    }
})

const id = route.params.id;
console.log("route.params.id: "+ id);

onMounted(async () => {
    state.data = await httpService.detail(id);
})

const doDel = async() =>{
    if(!confirm("삭제하시겠습니까?")){
        return;
    }
    const params = {id:state.data.id};
    const result = await httpService.del(params);
    
    if(result){
        router.push('/');
    }
}
const doMod = () =>{
    router.push(`/mod/${id}`);
}

</script>

<template>
    <h3>Detail Page</h3>
    <main>
        <div>id: {{ state.data.id }}</div>
        <div>date: {{ state.data.createdAt }}</div>
        <div>title: {{ state.data.title }}</div>
        <div>contents: {{ state.data.contents }}</div>
    </main>
    <div>
        <button @click="doDel">DEL</button>
        <button @click="doMod">MOD</button>
    </div>
</template>

<style scoped></style>