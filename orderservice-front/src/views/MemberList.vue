<script>
import axios from 'axios';

export default {
  name: "MemberList",
  data(){
    return{
      memberList : []
    }
  },
  async created() {

    try {
      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}
      this.memberList = await axios.get(`${process.env.VUE_APP_API_BASE_URL}/api/members`, {headers});
      this.memberList = this.memberList.data.result?.content;
      console.table(this.memberList);
    }catch (e) {
      console.table(e);
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>회원 목록</h1></div>
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
      <tr v-for = "member in memberList" :key="member.id">
        <td>{{member.id}}</td>
        <td>{{member.name}}</td>
        <td>{{member.email}}</td>
        <td>{{member.role}}</td>
        <td> <a :href="`/member/${member.id}/orders`"> {{member.orderCount}} </a> </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>