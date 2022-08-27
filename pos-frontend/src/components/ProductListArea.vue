<template>
  <div>
    <div class="search--card">
      <div class="row align-items-center">
        <div class="col-12 col-md-8 my-2">
          <input type="search" class="search--bar" v-model="searchKey" @blur="searchForProduct(searchKey)" placeholder="Search Product">
        </div>
        <div class="col-12 col-md-4 my-2">
          <ButtonComponent
                label="Search"
                buttonStyle="btn--primary"
                @onClick="searchForProduct(searchKey)"
                type="button"
            />
        </div>
    </div>
    </div>
    <div class="mt-3">
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
  </div>
</template>
<script>
// import { demoProducts } from "@/utils/demoProducts.js";

import ProductCard from "@/components/ProductCard.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";

import { mapGetters } from "vuex"

export default {
  name: "ProductListArea",
  data() {
    return {
      // products: demoProducts,
      searchKey : ""
    };
  },
  components: {
    ProductCard,
    ButtonComponent,
  },
  computed : {
    ...mapGetters({
      products : "getSearchList"
    })
  },
  methods: {
    addToCart(data) {
      this.$store.dispatch("ADD_PRODUCT_TO_CART", { product: data });
    },
    searchForProduct(searchKey){
      this.$store.dispatch("SEARCH_THE_PRODUCT", searchKey)
    }
  },
  created() {
    this.$store.dispatch("SEARCH_THE_PRODUCT")
  },
};
</script>
<style scoped>
.search--card{
  background-color: #FFFFFF;
  padding: 10px;
  border-radius: 10px;
}

.search--bar{
  background-color: #F1F1F1;
  border: 0.7px solid #e2e2e2;
  height: 40px;
  border-radius : 10px;
  padding-left : 10px;
  width: 100%;
}

.search--bar:focus{
  border: 1.5px solid #FF6665;
  outline: none;
}

</style>
