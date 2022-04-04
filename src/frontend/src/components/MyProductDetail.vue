<template>
  <div>
    <br>
    <h1>상품 수정 및 삭제 페이지 입니다.</h1>
    <div class="content-detail-content">
    <b-form v-on:submit.prevent="formSubmit" method="post" enctype="multipart/form-data">
      <label for="text-select">상품분류</label>
      <b-form-select v-if="myContent.kindid.kindid" v-model="myContent.kindid.kindid" :options="options" readonly></b-form-select>
      <div class="mt-3">선택유형 : <strong>{{ myContent.kindid.kindname }}</strong></div>

      <br>
      <label>메뉴명</label>
      <b-form-input v-if="myContent.menuname" v-model="myContent.menuname" placeholder="메뉴명을 입력하세요." :state="menuname" id="feedback-user" readonly></b-form-input>

      <br>
      <label for="text-select3">수량</label>
      <b-form-input v-if="myContent.stock" v-model="myContent.stock" placeholder="수량을 입력하세요." :state="stock" id="feedback-user" readonly></b-form-input>

      <br>
      <label for="text-select4">가격</label>
      <b-form-input v-if="myContent.price" v-model="myContent.price" placeholder="가격을 입력하세요." :state="price" id="feedback-user" readonly></b-form-input>

      <br>
      <label for="text-select5">설명</label>
      <b-form-input v-if="myContent.ex" v-model="myContent.ex" placeholder="설명을 입력하세요." :state="ex" id="feedback-user" readonly></b-form-input>

      <br>
      <b-form-file
        v-model="myContent.fileload"
        :state="Boolean(myContent.fileload)"
        class="form-control"
        type="file"
        id="file_load"
        placeholder="상품을 설명할 이미지 파일을 업로드하세요."
        readonly
        drop-placeholder="Drop file here...">

      </b-form-file>
      <div class="mt-3">Selected file: {{ myContent.fileload }}</div>
    </b-form>
    </div>

    <br>
    <div class="content-detail-button">
      <b-button variant="outline-primary" class="button" @click="updated">수정</b-button>
      <b-button variant="outline-danger" class="button" @click="deleted">삭제</b-button>
    </div>
  </div>

</template>

<script>
import axios from "axios";

export default {
  name: "MyProductDetail",
  data() {
    return {
      id: '',
      myContent: [],
    }
  },
  created() {
    this.myDataList();
  },
  methods: {
    myDataList() {
      this.id = this.$route.params.menuid;
      console.log(this.id);
      axios.get('http://localhost:8282/api/myProduct_detail/' + this.id)
        .then(res => {
          console.log(res.data);
          this.myContent = res.data;
        })
        .catch(e => {
          console.log(e);
        })
    }
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
