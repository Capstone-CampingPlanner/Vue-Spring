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
          :item="myProduct" @click="showInfo(myProduct)" style="cursor:pointer;">
        <th scope="row">{{ myProduct.menuid }}</th>
        <td>{{ myProduct.kindid.kindname }}</td>
        <td>{{ myProduct.menuname }}</td>
        <td>{{ myProduct.savedTime }}</td>
      </tr>
      <router-link :to="{name: 'MyProductDetail', params: { menuid:myProduct.menuid }}"></router-link>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "MyProductList",
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
      this.user = "dongmin";
      axios.get('http://localhost:8282/api/myProduct_list/' + this.user)
        .then((res) => {
          console.log(res.data);
          this.list = res.data;
        })
        .catch(e => {
          console.log(e)
        })
    },
    showInfo(myProduct) {
      this.$router.push({
        path: `/MyProductDetail/${myProduct.menuid}`
      })
    }

  }
}
</script>

<style scoped>

</style>
