<script setup>
import { reactive, onMounted } from 'vue';
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

const submit = async () => {
    if (state.data.id === 0) {
        const result = await httpService.save(state.data);
        console.log(result);

        if (result) { router.push('/') }
    } else {
        const result = await httpService.modify(state.data);
        if (result) { router.push(`/detail/${state.data.id}`) }
    }
    state.data.id = 0;
    state.data.title = '';
    state.data.contents = '';
}

onMounted(async () => {
    state.data.id = 0;
    state.data.title = '';
    state.data.contents = '';

    if (route.params.id) {
        const id = route.params.id;
        state.data = await httpService.findOne(id);
    }
})
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