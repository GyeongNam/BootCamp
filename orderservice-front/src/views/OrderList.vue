<script>
import OrderListComponent from "@/components/OrderListComponent.vue";
export default {
  components:{
    OrderListComponent
  }
}
</script>

<template>
<OrderListComponent
    :isAdmin="true"
    apiUrl="http://localhost:8080/api/orders"
/>
</template>

<style scoped>

</style>