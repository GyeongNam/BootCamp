<script>
import OrderListComponent from "@/components/OrderListComponent.vue";
export default {
  props:['id'],
  components:{
    OrderListComponent
  }
  ,
  data() {
    return {
      apiUrl: ''
    };
  }
  ,
  created() {
    this.apiUrl = `${process.env.VUE_APP_API_BASE_URL}/api/member/${this.id}/orders`;
  }
}
</script>

<template>
  <OrderListComponent
      :isAdmin="true"
      :apiUrl=apiUrl
  />
</template>

<style scoped>

</style>