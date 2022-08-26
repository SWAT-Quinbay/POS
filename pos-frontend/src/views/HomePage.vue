<template lang="">
  <div>
    <div class="container-fluid mt-5">
      <div class="row px-3">
        <div class="col-12 col-md-6 col-lg-7 col-xl-9">
            <ProductListArea/>
        </div>
        <div class="col-12 col-md-6 col-lg-5 col-xl-3">
            <BillingArea/>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

import ProductListArea from "@/components/ProductListArea.vue"
import BillingArea from "@/components/BillingArea.vue"

export default {
  name: "HomePage",
  components: {
    ProductListArea,
    BillingArea
  },
};
</script>
<style scoped>
</style>
