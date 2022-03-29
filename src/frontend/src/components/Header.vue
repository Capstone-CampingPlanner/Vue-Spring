<template>
  <div>
    <h1>판매자 전용메뉴입니다.</h1>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="/">판매자 관리</b-navbar-brand>

      <b-navbar-toggle target="nav_collapse"/>

      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav>
          <b-nav-item to="/userList">회원 정보</b-nav-item>
          <b-nav-item to="/board/free">자유게시판</b-nav-item>
          <b-nav-item to="/registration">상품 등록</b-nav-item>
          <b-nav-item to="/MyProduct">나의 상품</b-nav-item>
          <b-nav-item to="/ProductList">상품 리스트</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>


  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {};
  },
  methods: {

  }
};
</script>
