<script setup>
import { reactive, onMounted, h } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import httpService from '@/service/httpService';

const router = useRouter();
const route = useRoute();

const state = reactive({
    data: {
        id: 0,
        title: '',
        contents: '',
    }
})

onMounted(async () => {
    if (route.params.id) {
        state.data = await httpService.findOne(route.params.id)
        console.log(state.data);
    }
})

const submit = async () => {

    const result = state.data.id ? await httpService.modify(state.data) : await httpService.save(state.data);
    router.push({
        path: state.data.id? `/detail/${state.data.id}` : '/'
    })

    // if (state.data.id) {
    //     console.log(state.data);
    //     const result = await httpService.modify(state.data);
    //     console.log(result)
    //     if(result){
    //         router.push(`/detail/${state.data.id}`)
            
    //     }
    // } else {
    //     const result = await httpService.save(state.data)
    //     console.log(result);
    //     if(result){
    //         router.push('/')
    //     }
    // }
}

</script>

<template>
    <h3>Post Page</h3>

    <main>
        <div>
            <label>title: <input type="text" v-model="state.data.title"></label>
        </div>
        <div>
            <label>content: <textarea v-model="state.data.contents"></textarea></label>
        </div>
        <div><button @click="submit">등록</button></div>
    </main>

</template>

<style scoped></style>