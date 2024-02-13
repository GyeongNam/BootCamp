<template>
  <ItemListComponent
      :isAdmin="true"
      page-title="상품 관리"
  />
</template>

<script>
import ItemListComponent from "@/components/ItemListComponent.vue";

export default {
  components: {
    ItemListComponent
  },
}

</script>

<style lang="scss" scoped>

</style>