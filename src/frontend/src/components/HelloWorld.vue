<template>
  <div>
    <br>
    <div class="hello">
      <h2>{{ msg }}</h2>
      <b-button v-on:click="getData" pill variant="primary">판매자 인증</b-button>
      <b-button v-on:click="signup" type="button" pill variant="primary">판매자 등록</b-button>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import axios from "axios";

  export default {
    name: 'HelloWorld',
    data () {
      return {
        msg: 'API 호출 전'
      }
    },
    methods: {
      getData: function () {
        const baseURI = 'http://localhost:8282';
        this.$http.get(`${baseURI}/api/hello`)
          .then((result) => {
            console.log(result)
            this.msg = result.data
          })
      },
      signup: function () {
        const baseURI = 'http://localhost:8282';
        this.$http.post(`${baseURI}/api/signup`, null,{ params: { title:'POST방식 전달성공'}})
          .then((res) => {
            console.log("전달성공")
          })
          .catch((error) => {
            console.log("전달실패")
          })

        // this.$router.push({
        //   path: '/signup'
        // })

      }
    }
  }
</script>

<style>
.hello {
  background: skyblue;
}
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
