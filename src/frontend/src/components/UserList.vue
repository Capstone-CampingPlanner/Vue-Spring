<template>
  <div>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>생성일</th>
        <th>결제유형</th>
        <th>판매유형</th>
        <th>사업자번호</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in list"
          :key="item.id"
          :item="item" @click="showInfo(item.id)" style="cursor:pointer;">
        <td>{{ item.userid }}</td>
        <td>{{ item.password }}</td>
        <td>{{ item.savedTime }}</td>
        <td>{{ item.payment }}</td>
        <td>{{ item.sales_type }}</td>
        <td>{{ item.business_number }}</td>
      </tr>
      </tbody>
    </table>

    <div class="board_info" v-if="selected">
      <div style="float:right"><button @click="closeInfo">X</button></div>
      <div><button @click="deleteArticle(item.id)">삭제</button></div>
      <div><button @click="moveUpdatePage(item.id)">수정</button></div>
      <table>
        <input type="hidden" v-text="item.id">
        <tr><th>제목</th><td></td></tr>
        <tr><th>본문</th><td><span v-text="item.content"></span></td></tr>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Product",
  created() {
    this.fetchData()
  },
  data() {
    return {
      selected: false,
      list: [],
      item: null,
    }
  },
  methods: {
    fetchData() {
      const baseURI = 'http://localhost:8282';
      this.$http.get(`${baseURI}/api/user_list`)
        .then(response => {
          console.log(response.data);
          this.list = response.data;
        })
        .catch(error => {
          console.log(error)
        })
      },
    showInfo(id) {
      this.item = this.list[id]
      this.selected = true
    },
    closeInfo() {
      this.item = null
      this.selected = false
    },
    deleteArticle(id) {
      let articleId = id;
      this.$axios.delete('/api/boards/delete/' + articleId)
        .then(() => {
          window.location.reload();
        })
    },
    moveUpdatePage(id) {
      this.$router.push({ path: '/board/update/', query: { id : id}})
    }
  }
}
</script>

<style>

</style>
