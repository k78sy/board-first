<script setup>
import httpService from '@/service/httpService';
import { onMounted, reactive, watch } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const state = reactive({
    data: {
        title: '',
        contents: ''
    }
})


// watch( 감시할대상, (새로운값, 이전값) => { 실행할코드 } )
watch(
  () => route.params.id, // 1. 주소창의 id가 변하는지 지켜본다!
  async (newId) => {     // 2. id가 변하면 이 함수를 실행한다!
    if (newId) {
      // id가 존재하면? 수정 모드! 데이터를 불러와!
      state.data = await httpService.detail(newId);
    } else {
      // id가 사라지면? 글쓰기 모드! 데이터를 비워!
      state.data.id = 0;
      state.data.title = '';
      state.data.contents = '';
    }
  },
  { immediate: true } // 3. 컴포넌트가 처음 생길 때(Mounted 시점)도 실행해라!
);

const submit = async () => {
    if (!state.data.title) {
        alert("제목을 작성해주세요")
    } else if (!state.data.contents) {
        alert("내용을 작성해주세요")
    }

    const result = state.data.id ? await httpService.mod(state.data) : await httpService.save(state.data);

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
            <button v-if="state.data.id" @click="router.back()">BACK</button>
            <button @click="submit">SEND</button>
        </div>
    </main>
</template>

<style scoped></style>