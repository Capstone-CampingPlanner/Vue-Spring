<template>
  <div class="mt-4">
    <h4>상품 상세 페이지</h4>
    <b-card img-src="https://placekitten.com/300/300" img-alt="Card image" img-left class="mb-3">
      <b-card-text>
        <div class="content-detail-list">
        <h2>상품분류 : {{ this.content.kindid.kindname }}</h2><br>
        <h2>상품명 : {{ this.content.menuname }}</h2><br>
        <h2>상품에 대한 설명: {{ this.content.ex }}</h2><br>
        <h2>상품가격 : {{ this.content.price }}</h2><br>
        </div>
        <div class="content-detail-button">
        <b-button variant="outline-primary" class="button" @click="buyData">구매</b-button>
        <b-button variant="outline-info" class="button" @click="putData">찜</b-button>
        </div>
      </b-card-text>
    </b-card>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ProductDetail",
  created() {
    this.DataList();
  },
  data() {
    return {
      id: '',
      content: [],
    }

  },
  methods: {
    DataList() {
      this.id = this.$route.params.menuid;
      console.log(this.id);
      axios.get('http://localhost:8282/api/product_detail/' + this.id)
      .then(res => {
        console.log(res.data);
        this.content = res.data;
        console.log(this.content.menuid);
      })
      .catch(e => {
        console.log(e);
      })
    },

    buyData() {

    },
    putData() {

    }


  }
}
</script>

<style scoped>

.content-detail-button {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
}
.content-detail-list {
  margin-top: 1rem;
  padding: 1rem;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
.button {
  cursor: pointer;
}


</style>
