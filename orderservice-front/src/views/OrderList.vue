<script>
import OrderListComponent from "@/components/OrderListComponent.vue";
export default {
  components:{
    OrderListComponent
  },
  data() {
    return {
      apiUrl: ''
    };
  },
  created() {
    this.apiUrl = `${process.env.VUE_APP_API_BASE_URL}/api/orders`;
  }
}
</script>

<template>
<OrderListComponent
    :isAdmin="true"
    :apiUrl=this.apiUrl
/>
</template>

<style scoped>

</style>