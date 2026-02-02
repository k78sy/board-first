<script setup>
import httpService from '@/service/httpService';
import { reactive, onMounted } from 'vue';
import { useRoute,useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const state = reactive({
    data: {
        title: '',
        contents: ''
    }
})


onMounted(async () => {
    const id = route.params.id
    if (route.params.id) {
        state.data = await httpService.findOne(id);
    }
})

const submit = async () => {
    const result = route.params.id ? await httpService.modify(state.data) : await httpService.save(state.data);


    if (result) {
        state.data.title = '';
        state.data.contents = '';
        router.push(
            
            route.params.id? `/detail/${route.params.id}` : '/'

        )
    }
}

</script>

<template>
    <main>
        <div>title: <input type="text" v-model="state.data.title"></div>
        <div>contents: <textarea v-model="state.data.contents"></textarea></div>
        <div><button @click="submit">SEND</button></div>
    </main>
</template>

<style scoped></style>