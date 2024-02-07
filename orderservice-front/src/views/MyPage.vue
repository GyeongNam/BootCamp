<script>
import OrderListComponent from "@/components/OrderListComponent.vue";

export default {
  name: "MyPage",
  components: {
    OrderListComponent
  }

}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>회원 정보</h1></div>
    <table class="table">
      <thead>
      <tr>
        <th>id</th>
        <th>이름</th>
        <th>email</th>
        <th>권한</th>
        <th>주문수 </th>
      </tr>
      </thead>
      <tbody>
<!--      <tr v-for = "member in memberList" :key="member.id">-->
<!--        <td>{{member.id}}</td>-->
<!--        <td>{{member.name}}</td>-->
<!--        <td>{{member.email}}</td>-->
<!--        <td>{{member.role}}</td>-->
<!--        <td> <a :href="`/member/${member.id}/orders`"> {{member.orderCount}} </a> </td>-->
<!--      </tr>-->
      </tbody>
    </table>
  </div>

  <OrderListComponent
      apiUrl="http://localhost:8080/api/member/myInfo"
  />
</template>

<style scoped>

</style>