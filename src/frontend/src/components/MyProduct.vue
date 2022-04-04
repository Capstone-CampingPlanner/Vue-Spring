<template>
  <div>
    <br>
    <h1>내가 등록한 상품 리스트, 여기서 수정 및 삭제 </h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>#</th>
        <th>분류</th>
        <th>메뉴명</th>
        <th>등록일자</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="myProduct in list"
          :key="myProduct.id"
          :item="myProduct" @click="showInfo(myProduct.id)" style="cursor:pointer;">
        <th scope="row">{{ product.menuid }}</th>
        <td>{{ myProduct.kindid.kindname }}</td>
        <td>{{ myProduct.menuname }}</td>
        <td>{{ myProduct.savedTime }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "MyProduct",
  created() {
    this.goMyData()
  },
  data() {
    return {
      selected: false,
      list: [],
      myProduct: '',
    }
  },
  methods: {
    goMyData() {
      axios.get('http://localhost:8282/api/myProduct_list')
        .then((res) => {
          console.log(res.data);
          this.list = res.data;
        })
        .catch(e => {
          console.log(e)
        })
    },
    showInfo(id) {
      this.myProduct = this.list[id]
    }

  }
}
</script>

<style scoped>

</style>
