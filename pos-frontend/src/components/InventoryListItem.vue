<template>
  <!-- <div class="inventory--list my-1"> -->
    <tr>
      <th scope="row">
        <p class="inventory--table--tr">{{ product.id }}</p>
      </th>
      <td>
        <p class="inventory--table--tr">{{ product.name }}</p>
      </td>
      <td>
        <BadgeComponent :label="stockAnalysis ? 'Out of Stock' : 'Available'" />
      </td>
      <td>
        <p class="inventory--table--tr">{{ product.price }}</p>
      </td>
      <td>
        <p class="inventory--table--tr">{{ product.quantity }}</p>
      </td>
      <td>
        <ButtonComponent
          label="Edit"
          buttonStyle="btn--secondary"
          @onClick="editProduct(product)"
          type="button"
        />
      </td>
      <td>
        <ButtonComponent
          label="Delete"
          buttonStyle="btn--danger"
          @onClick="deleteProduct({ productId : product.id })"
          type="button"
        />
      </td>
    </tr>
</template>
<script>
import ButtonComponent from "@/components/ButtonComponent.vue";
import BadgeComponent from "@/components/BadgeComponent.vue";
import Vue from "vue";
import { deleteProductData } from "@/service/product.service.js";

export default {
  name: "InventoryListItem",
  data() {
    return {
      editModalToggle: false,
      showActionModal: false,
      modalData: {},
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
    BadgeComponent,
  },
  methods: {
    editProduct(data) {
      this.showActionModal = true;
      const constructedModalData = {
        modalHeader: "Edit Product Info",
        productData: data,
        modalButtonName: "Save Product",
      };
      this.$emit("triggerModalFromList", constructedModalData);
    },
    deleteProduct({ productId }) {
     deleteProductData({
        productId,
        successCallback: (res) => {
          console.log(res);
          if (res.status === 200) {
            Vue.$toast.success("Product Deleted!");
            this.$store.dispatch("SEARCH_THE_PRODUCT")
          } else {
            Vue.$toast.error();("Deletion Process declined!");
          }
        },
        errrorCallback: (err) => {
          Vue.$toast.error(err);
        },
      });
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

.inventory--table--tr {
  margin: 5px;
  font-size: 15px;
}
</style>
