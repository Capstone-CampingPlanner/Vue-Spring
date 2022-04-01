<template>
  <div>
    <h1>ㅎㅇ</h1>
  </div>
</template>

<script>
export default {
  name: "ProductDetail",
  data() {
    return {
      content: ''
    }

  },
  methods: {
    created() {
      this.fetchData();
    },
    fetchData() {
      const baseURI = 'http://localhost:8282';
      this.axios.get(`${baseURI}/api/product_detail` + this.$route.query.menuname)
      .then(res => {
        console.log(res.data);
        this.content = res.data;
      })
      .catch(e => {
        console.log(e);
      })
    }
  }
}
</script>

<style scoped>

</style>
