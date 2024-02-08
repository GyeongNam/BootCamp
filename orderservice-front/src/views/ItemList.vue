<script>
import axios from 'axios';

export default {
  name: "ItemList",

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
  placeOrder(){
    // 이 구조는 일일히 찍어보면서 파악 : console.log(this.selectedItems);
    //     {
    //         "1" : true,
    //         "2" : false,
    //     }
    // Object.keys : 위의 데이터 구조에서 1,2 등 key 값 추출하는 메서드
    // {orderReqItemDtos: [{itemId:1, count:2},{itemId:2, count:10} ]}
    const orderItems= Object.keys(this.selectedItems).filter(key=>this.selectedItems[key]===true)
        .map(key => {
          const item = this.itemList.find(item => item.id == key)
          return {itemId: item.id, count: item.quantity}
        })
    console.log(orderItems)
  }
  ,
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
        const addList = response.data.result.content.map({...this.item, quantity:1});
        if(addList.length < this.pageSize){
          this.isLastPage = true;
        }
        this.itemList = [...this.itemList, ...addList];
        // this.itemList = response.data.result.content;
      }catch(error){
        console.log(error)
      }
      this.isLoading = true;
    }
  }
  ,

}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px"><h1>상품 목록</h1></div>
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
      <div>
        <button @click="addCart" class="btn btn-secondary">장바구니</button>
        <button @click="placeOrder" class="btn btn-success">주문하기</button>
      </div>
    </div>
    <table class="table">
      <thead>
      <tr>
        <th></th>
        <th>제품사진</th>
        <th>제품명</th>
        <th>수량</th>
        <th>재고수량 </th>
        <th>주문수량 </th>
        <th>id </th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in itemList" :key="item.id">
        <td><input type="checkbox" v-model="selectedItem[item.id]" /></td>
        <td><img :src="getImage(item.id)" style="height: 100px; width: auto"/></td>
        <td>{{item.name}}</td>
        <td>{{item.price}}</td>
        <td>{{item.stockQuantity}}</td>
        <td><input type="number" style="width: 60px" v-model="item.quantity" /></td>
        <td>{{item.id}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>

</style>