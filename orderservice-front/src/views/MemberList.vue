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
      this.memberList = await axios.get("http://localhost:8080/api/members", {headers});
      this.memberList = this.memberList.data.result.content;
      console.table(this.memberList);
    }catch (e) {
      console.table(e);
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header"><h1>회원 목록</h1></div>
    <table class="table">
      <thead>
      <tr>
        <th>id</th>
        <th>이름</th>
        <th>email</th>
        <th>권한</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for = "member in memberList" :key="member.id">
        <td>{{member.id}}</td>
        <td>{{member.name}}</td>
        <td>{{member.email}}</td>
        <td>{{member.role}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>