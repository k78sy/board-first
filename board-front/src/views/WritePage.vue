<script setup>
import httpService from '@/service/httpService';
import { onMounted, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const state = reactive({
    data: {
        title: '',
        contents: ''
    }
})

onMounted(async () => {
    if (route.params.id) {
        state.data = await httpService.detail(route.params.id);
    }
})

const submit = async () => {
    if (!state.data.title) {
        alert("제목을 작성해주세요")
    } else if (!state.data.contents) {
        alert("내용을 작성해주세요")
    }

    const result = state.data.id ? await httpService.mod(state.data) : await httpService.save(state.data);

    // const result = await httpService.save(state.data);

    if (result) {
        router.push(
            state.data.id ? `/detail/${state.data.id}` : '/'
        );
    }
}
</script>

<template>
    <h3>Wirte Page</h3>
    <main>
        <div>
            <label>Title: <input type="text" v-model="state.data.title"></label>
        </div>
        <div>
            <label>Title: <textarea v-model="state.data.contents"></textarea></label>
        </div>
        <div>
            <button @click="submit">SEND</button>
        </div>
    </main>
</template>

<style scoped></style>