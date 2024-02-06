<template>
  <HeaderComponent/>
<!--  <HomeComponent/>-->
  <div>
    <router-view/>
  </div>

  <FooterComponent/>
</template>

<script>
/*
상대 경로
import HomeComponent from "./components/HomeComponent.vue";
절대경로
 */
// import HomeComponent from "@/components/HomeComponent.vue";
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
export default {
  components: {
    // HomeComponent,
    HeaderComponent,
    FooterComponent

  }

}
</script>

<style>

</style>
