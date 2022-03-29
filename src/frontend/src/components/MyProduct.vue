<template>
  <div>
    <br>
    <h1>내가 등록한 상품 리스트, 여기서 수정 및 삭제 </h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>분류</th>
        <th>메뉴명</th>
        <th>등록일자</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in list"
          :key="item.id"
          :item="item" @click="showInfo(item.id)" style="cursor:pointer;">
        <td>{{ item.userid }}</td>
        <td>{{ item.password }}</td>
        <td>{{ item.savedTime }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "MyProduct"
}
</script>

<style scoped>

</style>
