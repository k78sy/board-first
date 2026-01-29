<script setup>
import httpService from '@/service/httpService';
import { reactive } from 'vue';

const state = reactive({
    data: {
        title: '',
        contents: ''
    }
})

const submit = async () =>{
    const result = await httpService.postArticle(state.data);
    if(result){
        state.data.title = '';
        state.data.contents = '';
    }
}


</script>

<template>

    <h3>Post Page</h3>
    <div>
        <label>
            제목: <input type="text" v-model="state.data.title">
        </label>
        
    </div>
    <div><label>내용: <textarea v-model="state.data.contents"></textarea></label></div>
    <div>
        <button @click="submit">전송</button>
    </div>

</template>

<style scoped></style>