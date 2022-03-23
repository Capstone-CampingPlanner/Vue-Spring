<template>
  <div>
    <b-form  v-on:submit.prevent="submitForm">
      <label for="feedback-user">User ID</label>
      <b-form-input v-model="userId" placeholder="아이디를 입력하세요." :state="validation" id="feedback-user"></b-form-input>
      <b-form-invalid-feedback :state="validation">
        Your user ID must be 5-12 characters long.
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation">
        Looks Good.
      </b-form-valid-feedback>

      <label for="text-password">Password</label>
      <b-form-input v-model="password" placeholder="비밀번호를 입력하세요." type="password" id="text-password" aria-describedby="password-help-block"></b-form-input>
      <b-form-text id="password-help-block">
        Your password must be 8-20 characters long, contain letters and numbers, and must not
        contain spaces, special characters, or emoji.
      </b-form-text>
    </b-form>

    <b-button type="submit" @click="signSubmit" pill variant="primary">가입하기</b-button>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Signup",
  data() {
    return {
      userId: '',
      password: ''
    }
  },
  methods: {
    signSubmit: function () {
        console.log(this.userId, this.password);
        const url = 'http://localhost:8282/api/signup'
        const data = {
          userId: this.userId,
          password: this.password
        }
        axios.post(url, data)
          .then(function(response) { // eslint-disable-line no-unused-vars
            console.log("성공");
          })
          .catch(function(error) {
            console.log(error);
          })
      }


  },
  computed: {
    validation() {
      return this.userId.length > 4 && this.userId.length < 13
    }
  }


}
</script>

// scss 정의
<style>

</style>
