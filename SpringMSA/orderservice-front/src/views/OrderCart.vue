<script>
import {mapActions, mapGetters} from "vuex";
import axios from "axios";

export default {
  computed: {
    ...mapGetters(['getCartItems', 'getTotalQuantity'])
  },
  data() {
    return {

    }
  }
  ,
  methods:{
    ...mapActions(['clearCart']),
    async placeOrder(){
      const items = this.getCartItems.map(item => {
        return {
          item_id: item.id,
          quantity: item.quantity
        }
      })

      if(this.getTotalQuantity<1){
        alert('장바구니에 물건이 없습니다.')
        return;
      }

      if(!confirm(`${this.getTotalQuantity} 개 상품을 주문하시겠습니까?`)){
        console.log("주문이 취소 되었습니다.")
      }

      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}
      try {
        await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/order/new`, {items},{headers})
        console.log("주문이 완료되었습니다.")
        this.$store.dispatch('clearCart');
      }catch (e) {
        console.log(e)
        console.log("주문을 실패했습니다.")
      }
      console.log(items)
    }
    ,
    clearCart(){
      this.$store.dispatch('clearCart');
    }
  }
}

</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>장바구니 목록</h1></div>
    <table class="table">
      <thead>
      <tr>
        <th>제품 id</th>
        <th>제품 명</th>
        <th>주문 수량</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for = "item in getCartItems" :key="item.item_id">
        <td>{{item.item_id}}</td>
        <td>{{item.name}}</td>
        <td>{{item.quantity}}</td>
      </tr>
      </tbody>
    </table>
    <div class="d-flex justify-content-between">
      <button class="btn btn-secondary" @click="clearCart">장바구나 비우기</button>
      <button class="btn btn-success" @click="placeOrder">주문하기</button>
    </div>
  </div>
</template>

<style>

</style>