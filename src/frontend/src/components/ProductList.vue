<template>
  <div>
    <br>
    <h1>판매자들이 등록한 상품들의 리스트, 회원이 보게될 페이지</h1>
    <h1>각각의 상품을 클릭시 상세정보(구매 등)</h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>#</th>
        <th>메뉴명</th>
        <th>분류</th>
        <th>가격</th>
        <th>등록일자</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="product in list"
          :key="product.id"
          :item="product" @click="toDetail(product)">
        <th scope="row">{{ product.menuid }}</th>
        <td>{{ product.menuname }}</td>
        <td>{{ product.kindid.kindname }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.savedTime }}</td>
      </tr>
      <router-link :to="{name: 'productDetail', params: { menuid:product.menuid }}"></router-link>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "ProductList",
  created() {
    this.goData()
  },
  data() {
    return {
      selected: false,
      list: [],
      product: '',
    }
  },
  methods: {
    goData() {
      axios.get('http://localhost:8282/api/product_list')
        .then((res) => {
          console.log(res.data);
          this.list = res.data;
        })
        .catch(e => {
          console.log(e)
        })
    },
    toDetail(product){
      this.$router.push({
        path: `/ProductDetail/${product.menuid}`
      })
    }

  }
}
</script>

<style scoped>

</style>
