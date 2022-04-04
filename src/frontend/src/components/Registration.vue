<template>
  <div>
    <br>
    <h1>상품 등록 페이지 입니다.</h1>
    <div class="content-detail-content">
    <b-form v-on:submit.prevent="formSubmit" method="post" enctype="multipart/form-data">
      <label for="text-select">상품분류</label>
      <b-form-select v-model="kindid" :options="options"></b-form-select>
      <div class="mt-3">선택유형 : <strong>{{ kindid }}</strong></div>

      <br>
      <label>메뉴명</label>
      <b-form-input v-model="menuname" placeholder="메뉴명을 입력하세요." :state="menuname" id="feedback-user"></b-form-input>

      <br>
      <label for="text-select3">수량</label>
      <b-form-input v-model="stock" placeholder="수량을 입력하세요." :state="stock" id="feedback-user"></b-form-input>

      <br>
      <label for="text-select4">가격</label>
      <b-form-input v-model="price" placeholder="가격을 입력하세요." :state="price" id="feedback-user"></b-form-input>

      <br>
      <label for="text-select5">설명</label>
      <b-form-input v-model="ex" placeholder="설명을 입력하세요." :state="ex" id="feedback-user"></b-form-input>

      <br>
      <b-form-file
        v-model="file_load"
        :state="Boolean(file_load)"
        class="form-control"
        type="file"
        id="file_load"
        placeholder="상품을 설명할 이미지 파일을 업로드하세요."
        drop-placeholder="Drop file here...">

      </b-form-file>
      <div class="mt-3">Selected file: {{ file_load ? file_load.name : '' }}</div>
    </b-form>
    </div>

    <br>
    <div class="content-detail-button">
    <b-button variant="outline-primary" type="submit" @click="ProductSubmit">등록하기</b-button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

// let changeFile;
export default {
  name: "Registration",
  data() {
    return {
      kindid: '',
      menuname: '',
      stock: '',
      price: '',
      ex: '',
      file_load: '',
      userid: 'dongmin',
      subject: '',

      id: '',
      myContent: [],


      options: [
        { value: null, text: '판매하실 상품의 유형을 선택해주세요'},
        { value: '1', text: '오토캠핑'},
        { value: '2', text: '글램핑'},
        { value: '3', text: '카라반'},
        { value: '4', text: '펜션'},
        { value: '5', text: '렌트'},
        { value: '6', text: '쇼핑'},
      ],

    }
  },

  methods: {
    ProductSubmit: function () {
      const formData = new FormData();

      const photoFile = document.getElementById("file_load");

      formData.append('kindid', this.kindid);
      formData.append('menuname', this.menuname);
      formData.append('stock', this.stock);
      formData.append('price', this.price);
      formData.append('ex', this.ex);
      formData.append('file_load', photoFile.files[0]);
      formData.append('userid', this.userid);



      console.log(this.kindid, this.menuname, this.stock, this.price, this.ex, this.file_load, this.userid);
      const baseURI = 'http://localhost:8282';

      this.$http.post(`${baseURI}/api/product_signup`, formData, { headers: { 'Content-Type': 'multipart/form-data'}} )
        .then(res => {
          console.log("성공" + formData);
          alert("상품이 등록되었습니다.");
          this.$router.push({
            name: "MyProduct"
          });
        })
        .catch(function (error) {
          console.log("에러" + error);
          alert("상품이 등록되지않았습니다.");
        })


    },

  },
  computed: {

  }
}
</script>

<style scoped>
.content-detail-button {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
  size: 200px;
}
.button {
  cursor: pointer;
  size: 200px;
}
.content-detail-content {
  border: 1px solid black;
  margin-top: 2rem;
  padding-top: 2rem;
  min-height: 650px;
}
</style>
