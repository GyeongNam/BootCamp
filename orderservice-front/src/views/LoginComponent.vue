<script>
import axios from "axios";
import {jwtDecode} from "jwt-decode";

export default {
  name: "LoginComponent",
  data(){
    return{
      email: "",
      password: ""
    }
  },
  methods:{
    async doLogin(){

      /*
      2가지 예외 가능성 : 200번대 상태값이면서 token이 비어있는 경우
      200번대 상태값이 아닌경우
       */
      try {
        const loginData = {
          email : this.email,
          password : this.password
        }
        const response = await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/doLogin`, loginData);
        const token = response.data.result.token;
        if(token){
          const decoded = jwtDecode(token);
          console.table(decoded)
          localStorage.setItem("role", decoded.role);
          localStorage.setItem("email", decoded.sub);
          localStorage.setItem("token",token);
          /*
          created 함수는 reload 될때 1번만 실행되는 hook 함수
          그런데, router.push 를 통한 ㅇ환면전환은 reload 를 실행 시키지 않으므로 앞으로 created 함수 호출이 되지 않음
          this.$router.push("/")
           */
          location.href = "/";
        }else{
          console.error("200 ok but not token")
          alert("로그인 실패")
        }
      }catch (e) {
        console.table(e);
        const error = e.response.result;
        alert(error);
      }
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px">
      <h1>로그인</h1>
    </div>
    <form @submit.prevent="doLogin">
      <table class="table">
        <tr class="form-group">
          <td><label for="email">이메일 : </label></td>
          <td><input type="email" id="email" name="email" class="form-control" v-model="email"></td>
        </tr>
        <tr class="form-group">
          <td> <label for="pw">비밀번호 : </label></td>
          <td><input type="password" id="pw" name="pw" class="form-control" v-model="password"></td>
        </tr>
      </table>
      <button type="submit" class="btn btn-primary"> 로그인 </button>
    </form>
  </div>
</template>

<style scoped>

</style>