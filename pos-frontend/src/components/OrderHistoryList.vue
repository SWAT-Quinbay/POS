<template>
    <div class="orderhistory--list my-1">
    <div class="row mx-0 align-items-center justify-content-between">
      <div class="col">
        <p class="orderhistory--table--tr">{{ product.name }}</p>
      </div>
      <div class="col">
        <BadgeComponent :label="stockAnalysis ? 'Out of Stock' : 'Available'" />
      </div>
      <div class="col">
        <p class="orderhistory--table--tr">{{ product.price }}</p>
      </div>
      <div class="col">
        <p class="orderhistory--table--tr">{{ product.quantity }}</p>
      </div>
      <div class="col">
        <ButtonComponent
          label="Edit"
          buttonStyle="btn--secondary"
          @onClick="editProduct(product)"
          type="button"
          data-bs-toggle="modal"
          data-bs-target="#ActionModal"
        />
      </div>
      <div class="col">
        <ButtonComponent
          label="Delete"
          buttonStyle="btn--danger"
          @onClick="() => {}"
          type="button"
        />
      </div>
    </div>
    <hr class="orderhistory--single--list my-1" />
    <OrderHistoryActionModal modalAccessIdName="ActionModal" v-show="showActionModal" :modalData="modalData" />
  </div>
</template>
<script>
import OrderHistoryActionModal from "@/components/OrderHistoryActionModal.vue"
export default {
    name : "OrderHistroyList",
    props : {
        orderHistory : {
            type : Object,
            default : () => {}
        }
    },
    components : {
      OrderHistoryActionModal
    }
}
</script>
<style scoped>
    
</style>