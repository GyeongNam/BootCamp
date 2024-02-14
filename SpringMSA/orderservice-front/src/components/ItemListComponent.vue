<script>
import axios from 'axios';
import {mapActions} from "vuex";

export default {
  props:['isAdmin','pageTitle'],
  name: "ItemListManage",
  data(){
    return{
      itemList: [],
      pageSize: 5,
      currentPage: 0,
      searchType:'name',
      searchValue:'',
      isLastPage: false,
      isLoading: false,
      selectedItem: {}
    }
  },
  created() {
    this.loadItems()
  }
  ,
  mounted() {
    // scroll 동작이 발생할때마다 scrollPagination 함수가 호출된다는 의미
    window.addEventListener('scroll', this.scrollPagination)
  }
  ,
  methods:{
    ...mapActions(['addToCart'])
    ,
    addCart(){
      const items = Object.keys(this.selectedItem)
          .filter(key=>this.selectedItem[key]===true)
          .map(key => {
              const item = this.itemList.find(item => item.id == key)
              return {
                  item_id: item.id,
                  quantity: item.quantity,
                  name : item.name
              }
          });
      items.forEach(item =>
          // mutation 직접 호출 방식
          // this.$store.commit('addToCart', item),
          // actions 호출 방식
          this.$store.dispatch('addToCart',item)
      )
      this.selectedItem = []
    },
    scrollPagination(){
      /*
      innerHeight : 브라우저 창의 내부높이를 픽셀단위로 변환
      offsetHeight : 전체 브라우저 창의 높이
      scrollY : 스크롤로 통해 Y 축으로 이동한 거리
       */
      const nearBottom = window.innerHeight + window.scrollY >= document.body.offsetHeight - 500

      if(nearBottom && !this.isLastPage){
        // this.pageSize+=10;
        this.currentPage++;
        this.loadItems();
      }

    },
    getImage(id){
      return `${process.env.VUE_APP_API_BASE_URL}/api/item/${id}/image`
    },
    searchItems(){
      this.itemList = []
      this.currentPage = 0
      this.isLastPage = false
      this.loadItems();
    }
    ,
    async loadItems(){
      this.isLoading = true;
      try{
        const params = {
          page: this.currentPage,
          size: this.pageSize,
          // [this.searchType]: this.searchValue
        }

        if(this.searchType === "name"){
          params.name = this.searchValue
        }else if(this.searchType === "category"){
          params.category = this.searchValue
        }
        const response = await axios
            .get(`${process.env.VUE_APP_API_BASE_URL}/api/items`,{params})
        const addList = response.data.result.content.map(item=>({...item, quantity:1}));
        if(addList.length < this.pageSize){
          this.isLastPage = true;
        }
        this.itemList = [...this.itemList, ...addList];
        // this.itemList = response.data.result.content;
      }catch(error){
        console.log(error)
      }
      this.isLoading = true;
    },

    async deleteItem(itemID){
      if(confirm("정말로 삭제하시겠습니까?")){
        const token = localStorage.getItem("token");
        const headers = token ?  {Authorization: `Bearer ${token}`} : {}
        await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/item/${itemID}/delete`,{headers})
        location.reload()
      }

    },

    async placeOrder(){
      // 이 구조는 일일히 찍어보면서 파악 : console.log(this.selectedItems);
      //     {
      //         "1" : true,
      //         "2" : false,
      //     }
      // Object.keys : 위의 데이터 구조에서 1,2 등 key 값 추출하는 메서드
      // {orderReqItemDtos: [{itemId:1, count:2},{itemId:2, count:10} ]}


      const items = Object.keys(this.selectedItem)
          .filter(key=>this.selectedItem[key]===true)
          .map(key => {
            const item = this.itemList.find(item => item.id == key)
            return {
              item_id: item.id,
              quantity: item.quantity
            }
          })

      if(items.length < 1){
        alert('선택된 물건이 없습니다.')
        return;
      }

      if(!confirm(`${items.length} 개 상품을 주문하시겠습니까?`)){
        console.log("주문이 취소 되었습니다.")
      }


      const token = localStorage.getItem("token");
      const headers = token ?  {Authorization: `Bearer ${token}`} : {}
      await axios.post(`${process.env.VUE_APP_API_BASE_URL}/api/order/new`, {items},{headers})

      console.log(items)
    }
  }
  ,

}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1 >{{pageTitle}}</h1></div>
    <div class="d-flex justify-content-between" style="margin-top: 20px">
      <form @submit.prevent="searchItems">
        <select v-model=searchType  class="form-control" style="display: inline-block; width: auto; margin-right: 5px">
          <option value="optional">선택</option>
          <option value="name">상품명</option>
          <option value="category">카테고리</option>
        </select>
        <input v-model=searchValue type="text" />
        <button type="submit">검색</button>
      </form>
      <div v-if="!isAdmin">
        <button @click="addCart" class="btn btn-secondary">장바구니</button>
        <button @click="placeOrder" class="btn btn-success">주문하기</button>
      </div>
      <div v-if="isAdmin">
        <a href="/item/create"> <button class="btn btn-success">상품등록</button></a>
      </div>
    </div>
    <table class="table">
      <thead>
      <tr>
        <th v-if="!isAdmin"></th>
        <th>제품사진</th>
        <th>제품명</th>
        <th>수량</th>
        <th>재고수량 </th>
        <th v-if="!isAdmin">주문수량 </th>
        <th v-if="isAdmin">Action </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in itemList" :key="item.id">
        <td v-if="!isAdmin"><input type="checkbox" v-model="selectedItem[item.id]" /></td>
        <td><img :src="getImage(item.id)" style="height: 100px; width: auto"/></td>
        <td>{{item.name}}</td>
        <td>{{item.price}}</td>
        <td>{{item.stockQuantity}}</td>
        <td v-if="!isAdmin">
          <input type="number" style="width: 60px" v-model="item.quantity" />
        </td>
        <td v-if="isAdmin">
         <button class="btn btn-secondary" @click="deleteItem(item.id)"> 삭제 </button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>