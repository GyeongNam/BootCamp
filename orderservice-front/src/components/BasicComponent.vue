

<template>
  <h1> 홈 화면 </h1>
  <h1>hello world {{myLang}}</h1>
  <input type="text" value="myAal">
  <input type="text" :value="inputValue1">
  <input type="text" v-model="inputValue2">
  <!--
  :value 는  v-bind:value 의 축약어
  v-bind는 input 박스에서 많이 사용하는 변수 매핑
  -->

  <button @click="showValue()"> 버튼 </button>
  <div>
    <h2>{{count}}</h2>
    <button @click="increment">increment</button>
  </div>
  <div>
    <h2>{{doubleCount}}</h2>
    <button @click="increment">increment</button>
  </div>
</template>
<script >
  export default {
    name: "HOME",
    data(){
      return{
        myLang : "엄준식",
        inputValue1 : "한희준",
        inputValue2 : "신재석",
        count: 0
      }
    },
    created() {
      this.myLang = "박세종"
    },
    /*
    computed 는 종속된 반응형 데이터가 변경될 때만 함수를 다시 실행하여 값을 계산하는 계산함수
     */
    computed : {
      doubleCount(){
        return this.count * 2
      }
    }
    ,
    methods:{
      showValue(){
        alert(this.inputValue2)
      },
      increment(){
        this.count++
      }
    }
  }
</script>

<style scoped>

</style>