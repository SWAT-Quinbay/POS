<template>
  <div>
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
      <div class="inventory--table my-4">
        <div class="inventory--container">
            <div class="row p-3 justify-content-center">
          <div class="col">
            <p class="inventory--table--th">Product Name</p>
          </div>
          <div class="col">
            <p class="inventory--table--th">Description</p>
          </div>
          <div class="col">
            <p class="inventory--table--th">Price</p>
          </div>
          <div class="col">
            <p class="inventory--table--th">Quantity</p>
          </div>
          <div class="col">
            <p class="inventory--table--th">Edit</p>
          </div>
          <div class="col">
            <p class="inventory--table--th">Delete</p>
          </div>
        </div>
        <hr class="inventory--single--list">
        <InventoryListItem
          v-for="(data, index) in productList"
          :key="index"
          :product="data"
          @showModal="showModalToggle"
        />
        </div>
      </div>
    </div>
    <InventoryActionModal v-if="true" :modalData="modalData" />
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import products from "../utils/demoProducts";
import InventoryActionModal from "@/components/InventoryActionModal.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";
import InventoryListItem from "@/components/InventoryListItem.vue";

export default {
  name: "InventoryPage",
  data() {
    return {
      product: products,
      showModal: false,
      selectedProduct : {}
    };
  },
  components: {
    InventoryActionModal,
    ButtonComponent,
    InventoryListItem,
  },
  methods: {
    showModalToggle(data) {
      // alert(data)
      this.showModal = true;
      this.selectedProduct = data
    },
  },
  created() {
    this.$store.dispatch("GET_PRODUCT_LIST");
  },
  computed: {
    ...mapGetters({
      productList: "getProductList",
    }),
  },
};
</script>
<style scoped>
.search--card {
  background-color: #ffffff;
  padding: 10px;
  border-radius: 10px;
}

.inventory--table {
  background-color: #ffffff;
  /* padding: 10px; */
  border-radius: 10px;
}

.inventory--container{
}

.inventory--single--list{
        border: .5px solid #1b1b1b;
        margin: 0;
    }

.search--bar {
  background-color: #f1f1f1;
  border: 0.7px solid #e2e2e2;
  height: 40px;
  border-radius: 10px;
  padding-left: 10px;
  width: 100%;
}

.search--bar:focus {
  border: 1.5px solid #ff6665;
  outline: none;
}

.inventory--table--th{
    font-size: 13px;
    font-weight: 700;
    margin: 0;
}

/* .inventory{
   width:80% ; 
   margin-left:15%;
   background: white; 
    border:2px solid black;
    border-radius:35px;
     padding-left:10px;
}
.table td{
    
    background:white;
     border: 5px solid rgb(0, 0, 0);
     padding-right: 5px;
}
.table tr{
    border: 5px solid rgb(0, 0, 0);
} */
/* .table tr{
    border: 4px solid darkgrey;
    border-radius:50px;
} */
/* .table button{
    color:black;
    font-family: fantasy;
    border-radius: 8px;
} */
</style>
