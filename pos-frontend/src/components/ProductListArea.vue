<template>
  <div>
    <div class="row">
      <ProductCard
        class="col-12 col-md-6 col-lg-4 col-xl-3"
        v-for="(data, index) in products"
        :key="index"
        :product="data"
        @addToCart="addToCart(data)"
      />
    </div>
  </div>
</template>
<script>
import { demoProducts } from "@/utils/demoProducts.js";

import ProductCard from "@/components/ProductCard.vue";

export default {
  name: "ProductListArea",
  data() {
    return {
      products: demoProducts,
    };
  },
  components: {
    ProductCard,
  },
  methods: {
    addToCart(data) {
      this.$store.dispatch("ADD_PRODUCT_TO_CART", { product: data });
    },
  },
};
</script>
<style scoped></style>
