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


onMounted(async () => {
    const id = route.params.id;
    console.log(id);
    state.data = await httpService.findOne(id);
})

const doDel = async() =>{
    const params = {id: state.data.id}
    const result = await httpService.delete(params);
    console.log(result);
}
const doMod = () => {
    const id = route.params.id;
    router.push(`/mod/${id}`)
}

</script>

<template>
    <h3>디테일 페이지</h3>
    <main>
        <header>
            <p>{{ state.data.id }}</p>
            <p>{{ state.data.title }}</p>
            <p>{{ state.data.createdAt }}</p>
        </header>
        <main>
            {{ state.data.contents }}
        </main>
    </main>
    <div>
        <button @click="doDel">DELETE</button>
        <button @click="doMod">MOD</button>
    </div>
</template>

<style scoped></style>