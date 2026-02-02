<script setup>
import httpService from '@/service/httpService';
import { onMounted, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const router = useRouter();
const route = useRoute();

const state = reactive({
    data: {
        id: 0,
        title: '',
        contents: ''
    }
})


const id = route.params.id;
console.log("PathValuable : " + id)

onMounted(async () => {
    if(route.params.id){
    state.data = await httpService.detail(id);
    }
})

const submit = async () => {
    if (!state.data.title) {
        alert("제목을 작성해주세요")
        return;
    } else if (!state.data.contents) {
        alert("내용을 작성해주세요")
        return;
    }

    const result = route.params.id?  await httpService.update(state.data) : await httpService.save(state.data);

    if (result) {
        router.push(
            route.params.id? `/detail/${id}`:'/'
        )
    }
}
</script>

<template>
    <h3>Write Page</h3>

    <main>
        <div>
            <label>
                title: <input type="text" v-model="state.data.title">
            </label>
            <label>
                contents: <textarea v-model="state.data.contents"></textarea>
            </label>
        </div>
        <div><button @click="submit">SEND</button></div>
    </main>
</template>

<style scoped></style>