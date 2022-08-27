<template>
  <div class="inventory--list my-1">
    <div class="row mx-0 align-items-center justify-content-between">
      <div class="col">
        <p class="inventory--table--tr">{{ product.name }}</p>
      </div>
      <div class="col">
        <BadgeComponent :label="stockAnalysis ? 'Out of Stock' : 'Available'" />
      </div>
      <div class="col">
        <p class="inventory--table--tr">{{ product.price }}</p>
      </div>
      <div class="col">
        <p class="inventory--table--tr">{{ product.quantity }}</p>
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
    <hr class="inventory--single--list my-1" />
  </div>
</template>
<script>
import ButtonComponent from "@/components/ButtonComponent.vue";
import BadgeComponent from "@/components/BadgeComponent.vue";

export default {
  name: "InventoryListItem",
  data() {
    return {
      editModalToggle: false,
      showActionModal : false,
      modalData : {}
    };
  },
  props: {
    product: {
      type: Object,
      default: () => {},
    },
  },
  components: {
    ButtonComponent,
    BadgeComponent
  },
  methods: {
    editProduct(data) {
      this.showActionModal = true
      const constructedModalData = {
        modalHeader : "Edit Product Info",
        productData : data,
        modalButtonName : "Save Product"
      }
      this.$emit("showModal",constructedModalData)
      // alert(constructedModalData)
      // this.modalData = constructedModalData;
    },
    deleteProduct() {
      // const constructedModalData = {
      //   modalHeader : "Edit Product Info",
      //   productData : data,
      //   modalButtonName : "Save Product"
      // }
      // this.modalData = constructedModalData;
    },
  },
  computed: {
    stockAnalysis() {
      return this.product.quantity === 0;
    },
  },
};
</script>
<style scoped>
.inventory--single--list {
    margin: 0;
  border: 0.5px solid #999999;
}

.inventory--table--tr{
    margin: 0;
}
</style>
