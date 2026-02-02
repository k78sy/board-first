<script setup>
import httpService from '@/service/httpService';
import { reactive, onMounted } from 'vue';
import { useRoute,useRouter } from 'vue-router';

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
console.log("PathValuable : " + id)

onMounted(async () => {
    state.data = await httpService.detail(id);
})

const doDel = async () =>{
    if(!confirm("삭제하시겠습니까?")){
        return;
    }
    const params = {id:state.data.id}
    const result = await httpService.delete(params);
    if(result){
        router.push('/')
    }
}

const doMod = () =>{
    router.push(`/mod/${id}`)
}
</script>

<template>
    <h3>Detail Page</h3>
    <header>
        <p>ID: {{ state.data.id }}</p>
        <p>TITLE: {{ state.data.title }}</p>
        <p>DATE: {{ state.data.createdAt }}</p>
    </header>
    <main>
        <div>{{ state.data.contents }}</div>
    </main>
    <footer>
        <button @click="doDel">DELETE</button>
        <button @click="doMod">MODIFY</button>
    </footer>
</template>

<style scoped></style>