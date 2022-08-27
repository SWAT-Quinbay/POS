<template lang="">
    <div class="container-fluid mt-5">
      <div class="search--card">
        <div class="row align-items-center">
          <div class="col-12 col-md-6 col-lg-8 my-2">
            <input
              type="search"
              class="search--bar"
              v-model="searchKey"
              @blur="searchForProduct(searchKey)"
              placeholder="Search Product"
            />
          </div>
          <div class="col-6 col-md-3 col-lg-2 my-2">
            <ButtonComponent
              label="Search"
              buttonStyle="btn--primary"
              @onClick="searchForProduct(searchKey)"
              type="button"
            />
          </div>
          <div class="col-6 col-md-3 col-lg-2 my-2">
            <ButtonComponent
              label="Add Product"
              buttonStyle="btn--primary--outline"
              @onClick="searchForProduct(searchKey)"
              type="button"
            />
          </div>
        </div>
      </div>
      <div class="orderhistory--table my-4">
        <div class="orderhistory--container">
            <div class="row p-3 justify-content-center">
          <div class="col">
            <p class="orderhistory--table--th">Product Name</p>
          </div>
          <div class="col">
            <p class="orderhistory--table--th">Description</p>
          </div>
          <div class="col">
            <p class="orderhistory--table--th">Price</p>
          </div>
          <div class="col">
            <p class="orderhistory--table--th">Quantity</p>
          </div>
          <div class="col">
            <p class="orderhistory--table--th">Edit</p>
          </div>
          <div class="col">
            <p class="orderhistory--table--th">Delete</p>
          </div>
        </div>
        <hr class="orderhistory--single--list">
        <OrderHistoryList
          v-for="(data, index) in orderHistory"
          :key="index"
          :product="data"
          @showModal="showModalToggle"
        />
        </div>
      </div>
      <OrderHistoryActionModal v-show="showModal" @close-modal="showModal = false" />
    </div>
</template>
<script>
import { mapGetters } from "vuex";
import OrderHistoryActionModal from "@/components/OrderHistoryActionModal.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";
import OrderHistoryList from "@/components/OrderHistoryList.vue";
export default {
     name : "OrderHistory",
     components: {
            OrderHistoryActionModal,
            ButtonComponent,
            OrderHistoryList,
        },
     created() {
        this.$store.dispatch("GET_ORDER_HISTORY")
     },
     computed : {
        ...mapGetters({
            orderHistory : "getOrderHistory"
        })
     }
}
</script>
<style scoped>
    
</style>