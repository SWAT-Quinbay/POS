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
              @onClick="addProduct()"
              type="button"
            />
          </div>
        </div>
      </div>
      <div class="inventory--table my-4">
        <div class="table-responsive">
          <table class="table table-sm">
            <thead>
              <tr>
                <th scope="col">
                  <p class="inventory--table--th">Product Id</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Product Name</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Description</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Price</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Quantity</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Edit</p>
                </th>
                <th scope="col">
                  <p class="inventory--table--th">Delete</p>
                </th>
              </tr>
            </thead>
            <tbody class="">
              <InventoryListItem
                v-for="(data, index) in products"
                :key="index"
                :product="data"
                @triggerModalFromList="selectedProductFromList"
              />
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <InventoryActionModal
      v-if="showModal"
      @closeModal="closeModalToggle"
      @callBackForAction="updateProductDB"
      :modalObjectData="selectedProduct"
    />
  </div>
</template>
<script>
import { mapGetters } from "vuex";
// import products from "../utils/demoProducts";
import InventoryActionModal from "@/components/InventoryActionModal.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";
import InventoryListItem from "@/components/InventoryListItem.vue";
import Vue from "vue";
import {
  updateProductDetail,
  addNewProduct,
} from "@/service/product.service.js";

export default {
  name: "InventoryPage",
  data() {
    return {
      searchKey : "",
      // product: products,
      showModal: false,
      selectedProduct: {},
    };
  },
  components: {
    InventoryActionModal,
    ButtonComponent,
    InventoryListItem,
  },
  methods: {
    selectedProductFromList(data) {
      // alert(data)
      this.showModal = true;
      this.selectedProduct = data;
    },
    addProduct() {
      const constructedData = {
        modalHeader: "Add New Product",
        productData: null,
        modalButtonName: "Create Product",
      };
      this.showModal = true;
      this.selectedProduct = constructedData;
    },
    closeModalToggle() {
      this.showModal = false;
      this.selectedProduct = {};
    },
    updateProductDB(product) {
      console.log(product);
      if (!product.id) {
        addNewProduct({
          productData: product,
          successCallback: (res) => {
            console.log(res);
            if (res.status === 200) {
              Vue.$toast.success("Inventory Updated!");
              this.$store.dispatch("SEARCH_THE_PRODUCT")
            } else {
              Vue.$toast.error();
              ("Updated Process declined!");
            }
          },
          errrorCallback: (err) => {
            Vue.$toast.error(err);
          },
        });
      } else {
        updateProductDetail({
          productData: product,
          successCallback: (res) => {
            console.log(res);
            if (res.status === 200) {
              Vue.$toast.success("Inventory Updated!");
              this.$store.dispatch("SEARCH_THE_PRODUCT")
            } else {
              Vue.$toast.error();
              ("Updated Process declined!");
            }
          },
          errrorCallback: (err) => {
            Vue.$toast.error(err);
          },
        });
      }

      this.showModal = false;
    },
    searchForProduct(searchKey){
      this.$store.dispatch("SEARCH_THE_PRODUCT", searchKey)
    }
  },
  created() {
    // this.$store.dispatch("GET_PRODUCT_LIST");
    this.$store.dispatch("SEARCH_THE_PRODUCT")
  },
  computed: {
    ...mapGetters({
      productList: "getProductList",
      products : "getSearchList"
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

.inventory--container {
}

.inventory--single--list {
  border: 0.5px solid #1b1b1b;
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

.inventory--table--th {
  font-size: 15px;
  font-weight: 700;
  margin: 5px;
}
</style>
