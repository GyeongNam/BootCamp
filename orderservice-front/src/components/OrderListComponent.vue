<script>
import axios from 'axios';

export default {
  name: "OrderList",
  props:[
      'isAdmin','apiUrl'
  ]
,
  data(){
    return{
      orderList : [],
      visibleOrder : new Set(),
    }
  },
  async created() {
    try {
      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}
      const response = await axios.get(this.apiUrl, {headers});
      this.orderList = response.data.result?.content;
      console.table(this.orderList);
    }catch (e) {
      console.table(e);
    }
  }
  ,
  methods:{
    toggleOrder(orderId){
      if(this.visibleOrder.has(orderId)){
        this.visibleOrder.delete(orderId)
      }else{
        this.visibleOrder.add(orderId)
      }
    }
    ,
     async orderCancel() {
      if(confirm("정말 삭제하시겠습니까?")){
        try {
          const token = localStorage.getItem("token");
          const headers = token ? {Authorization: `Bearer ${token}`} : {};
          // `http://localhost:8080/api/order/${orderId}/cancel`
          const response = await axios.patch(this.apiUrl , {headers});
          this.orderList = response.data.result?.content;
          console.table(this.orderList);
        } catch (e) {
          console.table(e);
        }
      }
     }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>주문 목록</h1>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>이메일</th>
          <th>주문상태</th>
          <th v-if="isAdmin === true" >ACTION</th>
        </tr>
      </thead>
      <tbody>
        <template v-for = "order in orderList" :key="order.id">
        <tr @click="toggleOrder(order.id)" style="cursor: pointer">
          <td>{{order.id}}</td>
          <td>{{order.email}}</td>
          <td>{{order.orderStatus}}</td>
          <td><button v-if="order.orderStatus === 'ORDERED' && isAdmin === true"  @click.stop="orderCancel(order.id)">CANCEL</button></td>
        </tr>
        <tr v-if="visibleOrder.has(order.id)">
          <td colspan="4">
            <span v-for="orderItem in order.orderItems" :key="orderItem.id">
              <ul>
                <li>{{orderItem.item_name}} {{orderItem.quantity}}</li>
              </ul>
            </span>
          </td>
        </tr>
        </template>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>