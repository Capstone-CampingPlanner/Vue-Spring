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
        this.$http.get(`${baseURI}/api/hello2`)
          .then(response => {
            console.log(response)
            this.msg = response.data;
          })
        .catch(error => {
          console.log(error)
        })
      },

      signup: function () {
        this.$router.push({
          path: '/signup'
        })

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
