<template lang="">
  <div>
    <div class="container-fluid mt-5">
      <div class="row px-3">
        <div class="col-12 col-md-6 col-lg-7 col-xl-9 order-1 order-md-0 mt-2">
            <ProductListArea/>
        </div>
        <div class="col-12 col-md-6 col-lg-5 col-xl-3 order-0 order-md-1 mt-2">
            <div class="fixed--col">
              <BillingArea/>
            </div>
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
  // created(){
  //     if(localStorage.token==undefined)
  //     { 
  //       this.$router.push(`/login`);  
  //     }
  // }
};
</script>
<style scoped>
.fixed--col{
  position: sticky;
  top: 5%;
}
</style>
