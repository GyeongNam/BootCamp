<template>
  <div class="container">
    <div class="page-header">
      <h1>상품 등록</h1>
    </div>
    <form @submit.prevent="itemCreate" >
      <table class="table">
        <tr class="form-group">
          <td><label for="name">상품명 : </label></td>
          <td><input type="text" id="name" name="name" v-model="name" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="category">카테고리 : </label></td>
          <td><input type="text" id="category" name="category" v-model="category" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="price">가격 : </label></td>
          <td><input type="text" id="price" name="price" v-model="price" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td> <label for="stockQuantity">재고수량 : </label></td>
          <td><input type="text" id="stockQuantity" name="stockQuantity" v-model="stockQuantity" class="form-control"></td>
        </tr>
        <tr class="form-group">
          <td><label for="password">상품 이미지 : </label></td>
          <td><input type="file" id="image" name="image" accept="image/*" @change="fileUpload" class="form-control"></td>
        </tr>
      </table>
      <button type="submit"  class="btn btn-primary"> 등록 </button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name : 'ItemCreate'
  ,
  data(){
    return{
      name:"",
      category:"",
      price:null,
      stockQuantity:null,
      itemImage:null,
    }

  },
  methods:{
    fileUpload(event){
      this.itemImage = event.target.files[0];
    }
    ,
    async itemCreate() {
      const registerData = new FormData();
      registerData.append("name", this.name)
      registerData.append("stockQuantity", this.stockQuantity)
      registerData.append("category", this.category)
      registerData.append("price", this.price)
      registerData.append("itemImage", this.itemImage)

      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}

      await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/item/create`, registerData,{headers})
      this.$router.push('/item/manage')
    }
  }
}
</script>

<style lang="scss" scoped>

</style>