<template>
  <div>
    <br>
    <h1>상품 등록 페이지 입니다.</h1>
    <b-form  v-on:submit.prevent="formSubmit" method="post">
      <label for="text-select">상품분류</label>
      <b-form-select v-model="kind" :options="options"></b-form-select>
      <div class="mt-3">선택유형 : <strong>{{ kind }}</strong></div>

      <br>
      <label for="text-select2">메뉴명</label>
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
        v-model="fileload"
        :state="Boolean(fileload)"
        class="form-control"
        type="file"
        id="photo" name="photo"
        placeholder="상품을 설명할 이미지 파일을 업로드하세요."
        drop-placeholder="Drop file here...">

      </b-form-file>
      <div class="mt-3">Selected file: {{ fileload ? fileload.name : '' }}</div>
    </b-form>

    <br>
    <b-button type="submit" @click="ProductSubmit" pill variant="primary">등록하기</b-button>

  </div>
</template>

<script>
import axios from 'axios'

let changeFile;
export default {
  name: "Registration",

  data() {
    return {
      kind: '',
      menuname: '',
      stock: '',
      price: '',
      ex: '',
      fileload: '',
      member: 'rigun',



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

      const photoFile = document.getElementById("photo");

      formData.append('kind', this.kind);
      formData.append('menuname', this.menuname);
      formData.append('stock', this.stock);
      formData.append('price', this.price);
      formData.append('ex', this.ex);
      formData.append('fileload', photoFile.files[0]);
      formData.append('member', this.member);



      console.log(this.kind, this.menuname, this.stock, this.price, this.ex, this.fileload, this.member);
      const baseURI = 'http://localhost:8282';

      this.$http.post(`${baseURI}/api/product_signup`, formData, { headers: { 'Content-Type': 'multipart/form-data'}} )
        .then(res => {
          console.log("성공" + formData);
        })
        .catch(function (error) {
          console.log("에러" + error);
        })
    }
  },
  computed: {

  }
}
</script>

<style scoped>

</style>
