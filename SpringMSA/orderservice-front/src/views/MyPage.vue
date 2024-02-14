<script>
import OrderListComponent from "@/components/OrderListComponent.vue";
import axios from "axios";

export default {
  name: "MyPage",
  components: {
    OrderListComponent
  },
  data(){
    return{
      apiUrl: '',
      member : []
    }
  },
  async created() {
    this.apiUrl = `${process.env.VUE_APP_API_BASE_URL}`;
    try {
      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}
      const response = await axios.get(`${this.apiUrl}/api/member/myInfo`, {headers});
      this.member = response.data;
      console.table(this.member);
    }catch (e) {
      console.table(e);
    }
  }
  ,

}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>회원 정보</h1></div>
    <table class="table">
      <tr>
        <td>id</td>
        <td>{{ member.id }}</td>
      </tr>
      <tr>
        <td>이름</td>
        <td>{{ member.name }}</td>
      </tr>
      <tr>
        <td>email</td>
        <td>{{ member.email }}</td>
      </tr>
      <tr>
        <td>권한</td>
        <td>{{ member.role }}</td>
      </tr>
      <tr>
        <td>주문수 </td>
        <td>{{ member.orderCount }}</td>
      </tr>
    </table>
  </div>

  <OrderListComponent v-if="member.id"
      :apiUrl="`${apiUrl}/api/member/${member.id}/orders`"
  />
</template>

<style scoped>

</style>