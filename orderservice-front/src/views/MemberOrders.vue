<script>
import OrderListComponent from "@/components/OrderListComponent.vue";
export default {
  props:['id'],
  components:{
    OrderListComponent
  }
}
</script>

<template>
  <OrderListComponent
      :isAdmin="true"
      :apiUrl="`http://localhost:8080/api/member/${id}/orders`"
  />
</template>

<style scoped>

</style>