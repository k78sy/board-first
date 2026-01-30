<script setup>
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import httpService from '@/service/httpService';

const router = useRouter();

const state = reactive({
    data:{
        title:'',
        contents:'',
    }
})

const submit = async () => {
    const result = await httpService.save(state.data);
    console.log(result);

    if(result){
        router.push('/')
    }
}

</script>

<template>
<h3>Post Page</h3>

<main>
    <div>
        <label for="">title: <input type="text" v-model="state.data.title"></label>
    </div>
    <div>
        <label for="">content: <textarea  v-model="state.data.contents"></textarea></label>
    </div>
    <div><button @click="submit">등록</button></div>
</main>

</template>

<style scoped>

</style>