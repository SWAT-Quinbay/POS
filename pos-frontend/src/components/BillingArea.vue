<template>
  <div class="billing--card">
    <div class="billing--card--header">
      <div class="d-flex justify-content-between align-item-center">
        <div>
          <p class="card--header">New Order Bill</p>
        </div>
        <div>
          <button class="cart--clear" @click="$store.commit('clearCart')">
            Clear
          </button>
        </div>
      </div>
    </div>
    <hr class="billig--hr" />
    <div class="product--listing">
      <div v-if="cartProducts.length > 0">
        <CartProductItem
          v-for="(data, index) in cartProducts"
          :productIndex="index"
          :key="index"
          :product="data"
        />
      </div>
      <div v-else class="d-flex justify-content-center my-4">
        <p><small>No products in cart!</small></p>
      </div>
    </div>
    <hr class="billig--hr" />
    <div class="billing--total--card">
      <div class="d-flex justify-content-between">
        <div><p class="billing--header">Sub Total</p></div>
        <div>
          <p class="billing--subheader">₹ {{ totalPrice }}</p>
        </div>
      </div>
      <div class="d-flex justify-content-between">
        <div>
          <p class="billing--header">Tax {{ tax }}% (VAT Included)</p>
        </div>
        <div>
          <p class="billing--subheader">₹ {{ calculateTax }}</p>
        </div>
      </div>
      <hr class="billing--dot" />
      <div class="d-flex justify-content-between">
        <div><p class="billing--total--text">Total</p></div>
        <div>
          <p class="billing--total--value">₹ {{ getNetPrice }}</p>
        </div>
      </div>
    </div>
    <hr class="billig--hr" />
    <div class="billing--payment--card">
      <p class="billing--payment--header">Payment Method</p>
      <select v-model="paymentMethod" name="payment-option" id="payment-method">
        <option :value="null">Select Payment option</option>
        <option
          v-for="(data, index) in ['Cash', 'Debit Card', 'Credit Card']"
          :key="index"
          :value="data"
        >
          {{ data }}
        </option>
      </select>
      <div class="mt-4">
        <ButtonComponent
          label="Place Order"
          @onClick="generateBilling()"
          type="button"
          data-bs-toggle="modal"
          data-bs-target="#billingModal"
        />
      </div>
    </div>

    <BillingModal modalAccessIdName="billingModal" v-show="showBillingModal" :paymentMethod="paymentMethod" />
  </div>
</template>
<script>
import CartProductItem from "@/components/CartProductItem.vue";
import ButtonComponent from "@/components/ButtonComponent.vue";
import BillingModal from "@/components/BillingModal.vue";
import { mapGetters } from "vuex";

export default {
  name: "BillingArea",
  data() {
    return {
      paymentMethod: null,
      placeOrderLoader: false,
      orderDataToModal: {},
      showBillingModal : false
    };
  },
  components: {
    CartProductItem,
    ButtonComponent,
    BillingModal,
  },
  computed: {
    ...mapGetters({
      cartProducts: "getCartProduct",
      totalPrice: "getTotalPrice",
      tax: "getTax",
    }),
    getNetPrice() {
      return Math.floor(this.totalPrice + (this.totalPrice / 100) * this.tax);
    },
    calculateTax() {
      return Math.floor((this.totalPrice / 100) * this.tax);
    },
  },
  methods: {
    generateBilling() {
      const orderData = {
        orderItems: this.cartProducts,
        subTotal: this.totalPrice,
        // netTotal: this.totalPrice + this.tax,
        tax: this.tax,
        paymentMethod: this.paymentMethod,
        status : "created"
      };

    console.log()
// 
      this.showBillingModal = true

      this.orderDataToModal = orderData;

      // createNewOrder({
      //   orderData,
      //   successCallback: (res) => {
      //     console.log(res)
      //     if(res.status === 200){

      //     }else{

      //     }
      //     // commit("updateSearchList", data);
      //   },
      //   errrorCallback: (errorResponse) => {
      //     console.log(errorResponse);
      //   },
      // });
    },
  },
};
</script>
<style scoped>
.billing--card {
  background-color: #ffffff;
  border-radius: 15px;
  box-shadow: rgba(0, 0, 0, 0.04) 0px 3px 5px;
}
.billing--cart--image {
  width: 80px;
  height: 80px;
  border-radius: 15px;
}
.billing--total--card {
  /* background-color: #FFFFFF; */
  margin-top: 15px;
  padding: 5px 15px;
}
.billing--card--header {
  padding: 10px;
}
.card--header {
  margin: 0;
  font-size: 16px;
  font-weight: 600;
  margin-top: 5px;
  margin-left: 5px;
}

.billig--hr {
  margin: 0;
  border-color: #b0b0b0;
}
.product--listing {
  margin: 10px;
  max-height: 300px;
  overflow: auto;
  border-radius: 10px;
  border: 0.5px solid #dbdbdb;
  padding: 5px;
}
.cart--clear {
  background-color: #fde3e6;
  color: red;
  border: none;
  outline: none;
  border-radius: 5px;
  padding: 5px 15px;
  font-weight: 600;
  font-size: 13px;
}
.billing--header {
  font-size: 13px;
  font-weight: 500;
  margin: 0;
}

.billing--subheader {
  font-size: 14px;
  font-weight: bolder;
  margin: 0;
}

.billing--total--text {
  font-size: 16px;
  font-weight: bolder;
  color: #000000;
}

.billing--total--value {
  font-size: 16px;
  font-weight: bolder;
  color: #33bc06;
}

.billing--dot {
  border-style: dashed;
}

.billing--payment--card {
  padding: 15px;
}

.billing--payment--header {
  font-size: 15px;
  font-weight: bolder;
}

#payment-method {
  width: 100%;
  background-color: #f1f1f1;
  height: 40px;
  border-radius: 10px;
  color: #474747;
  border: none;
  padding-left: 10px;
  font-size: 14px;
}

#payment-method:focus {
  border-color: #ff6665;
  outline-color: #ff6665;
}
</style>
