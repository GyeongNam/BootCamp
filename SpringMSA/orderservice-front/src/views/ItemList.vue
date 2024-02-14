<template>
  <ItemListComponent
      :isAdmin="false"
      page-title="상품 목록"
  />
</template>

<script>
import ItemListComponent from "@/components/ItemListComponent.vue";

export default {
  components:{
    ItemListComponent
  },
}

</script>

<style lang="scss" scoped>

</style>