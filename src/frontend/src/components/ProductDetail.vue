<template>
  <div>
    <h1>상세페이지</h1>
  </div>
</template>

<script>
export default {
  name: "ProductDetail",
  created() {
    this.id = this.$route.query.menuid;
  },
  data() {
    return {
      content: ''
    }

  },
  methods: {
    mounted() {
      this.fetchData();
    },
    fetchData() {
      const baseURI = 'http://localhost:8282';
      console.log(this.id)
      this.axios.get(`${baseURI}/api/product_detail` + this.$route.query.menuid)
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
