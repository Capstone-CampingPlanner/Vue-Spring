<template>

</template>

<script>
import axios from 'axios'

export default {
  name: "MyProductDetail",
  created() {
    this.myDataList();
  },
  data() {
    return {
      id: '',
      myContent: [],
    }
  },

  methods: {
    myDataList() {
      this.id = this.$route.params.menuid;
      console.log(this.id);
      axios.get('http://loaclhost:8282/api/myProduct_list/' + this.id)
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

</style>
