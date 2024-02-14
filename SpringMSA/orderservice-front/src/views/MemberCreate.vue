<script>


import axios from "axios";
export default {
  name: "MemberCreate",
  data(){
    return {
      name : "",
      email: "",
      password: "",
      city : "",
      street : "",
      zipcode : ""
    }
  },
  methods:{
    async memberCreate(){
      try{
        const registerData = {
          name : this.name,
          email: this.email,
          password: this.password,
          city : this.city,
          street : this.street,
          zipcode : this.zipcode,
        };
        await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/member/create`, registerData);
        // location.href="/login"
        this.$router.push(
            {name : 'Login'}
        );
      } catch(e){
        console.table(e);
        const error = e.response.data.result;
        alert(error);
      }
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header">
      <h1>회원 가입</h1>
    </div>
    <form @submit.prevent="memberCreate" >
      <table class="table">
        <tr class="form-group">
          <td><label for="name">이름 : </label></td>
          <td><input type="text" id="name" name="name" v-model="name" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td> <label for="email">이메일 : </label></td>
          <td><input type="text" id="email" name="email" v-model="email" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="password">비밀번호 : </label></td>
          <td><input type="text" id="password" name="password" v-model="password" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="city">도시 : </label></td>
          <td><input type="text" id="city" name="city" v-model="city" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="street">상세주소 : </label></td>
          <td><input type="text" id="street" name="street" v-model="street" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="zipcode">우편번호 : </label></td>
          <td><input type="text" id="zipcode" name="zipcode" v-model="zipcode" class="form-control"></td>
        </tr>

      </table>
      <button type="submit"  class="btn btn-primary"> 가입 </button>
    </form>
  </div>
</template>

<style scoped>

</style>