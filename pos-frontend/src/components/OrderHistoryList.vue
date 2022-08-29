<template>
  <tr>
    <th scope="row">
      <p class="orderhistory--table--tr">{{ order.id }}</p>
    </th>
    <td>
      <p class="orderhistory--table--tr">{{ getTimeFormat }}</p>
    </td>
    <td>
      <BadgeComponent :label="orderStatus ? 'canceled' : 'created'" />
    </td>
    <td>
      <p class="orderhistory--table--tr">₹{{ calculatedaxByTax }}</p>
    </td>
     <td>
      <p class="orderhistory--table--tr">
        <ul>
          <li v-for="(data,index) in order.orderItems" :key="index">{{ data.name}}</li>
        </ul>
      </p>
    </td>
    <td>
        <ButtonComponent
          :label="orderStatus  ? 'Order Cancelled' : 'Cancel Order'"
          :buttonStyle="[ orderStatus  ? 'btn--disabled' : 'btn--danger']"
          :disabled="orderStatus ? true : false"
          @onClick="cancelOrderFromOrders(order.id)"
          type="button"
        />
    </td>
  </tr>
</template>
<script>
import ButtonComponent from "@/components/ButtonComponent.vue";
import BadgeComponent from "@/components/BadgeComponent.vue";
import Vue from "vue";
import { cancelOrder } from "@/service/order.service.js";



export default {
  name: "OrderHistroyList",
  props: {
    order: {
      type: Object,
      default: () => {},
    },
  },
  computed: {
    orderStatus() {
      return this.order.status === "canceled";
    },
    calculatedaxByTax() {
      return Math.floor(
        this.order.subTotal + (this.order.subTotal / 100) * this.order.tax
      );
    },
    getTimeFormat() {
      return new Date(this.order.createdTime).toDateString();
    },
  },
  components: {
    ButtonComponent,
    BadgeComponent,
  },
  methods: {
    cancelOrderFromOrders(orderId) {
      cancelOrder({
        orderId,
        successCallback: (res) => {
          console.log(res);
          if (res.status === 200) {
            Vue.$toast.success("Order Cancelled Successfully!");
            this.$store.dispatch("GET_ORDER_HISTORY");
          } else {
            Vue.$toast.error();
            ("Cancellation Process declined!");
          }
        },
        errrorCallback: (err) => {
          Vue.$toast.error(err);
        },
      });
    },
    downloadBill() {
      // alert("in billing modals")
      const dataToBilling = {
        cartProducts: this.cartProducts,
        totalItems: this.cartProducts.length,
        totalPrice: this.totalPrice,
        tax: this.tax,
        netPrice: this.getNetPrice,
        taxAmount: this.calculateTax,
        time: this.getTime,
        date: this.getData,
      };

      console.log(dataToBilling);

      this.$refs.billPage.generateBill(dataToBilling);

      // this.billTemData = dataToBilling;
      // this.billingTemplate = true;
      // alert(this.getNetPrice)
    },
  },
};
</script>
<style scoped>
.orderhistory--single--list {
  margin: 0;
  border: 0.5px solid #999999;
}

.orderhistory--table--tr {
  margin: 5px;
  font-size: 15px;
}
</style>
