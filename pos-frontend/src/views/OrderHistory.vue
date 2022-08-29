<template >
  <div class="container-fluid mt-5">
    <div class="orderhistory--table my-4">
      <div class="orderhistory--container">
        <div class="table-responsive">
          <table class="table table-sm ">
          <thead>
            <tr>
              <th scope="col">
                <p class="orderhistory--table--th">Order Id</p>
              </th>
              <th scope="col">
                <p class="orderhistory--table--th">Date</p>
              </th>
              <th scope="col">
                <p class="orderhistory--table--th">Status</p>
              </th>
              <th scope="col">
                <p class="orderhistory--table--th">Total Price</p>
              </th>
              <th scope="col">
                <p class="orderhistory--table--th">Items List</p>
              </th>
               <th scope="col">
                <p class="orderhistory--table--th">Action</p>
              </th>
            </tr>
          </thead>
          <tbody class="">
            <OrderHistoryList
              v-for="(data, index) in orderHistory"
              :key="index"
              :order="data"
            />
          </tbody>
        </table>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import OrderHistoryList from "@/components/OrderHistoryList.vue";
export default {
  name: "OrderHistory",
  data(){
    return{
      orderData : {}
    }
  },
  components: {
    // ButtonComponent,
    OrderHistoryList
  },
  created() {
    this.$store.dispatch("GET_ORDER_HISTORY");
  },
  computed: {
    ...mapGetters({
      orderHistory: "getOrderHistory",
    }),
  }
};
</script>
<style scoped>
.search--card {
  background-color: #ffffff;
  padding: 10px;
  border-radius: 10px;
}

.orderhistory--table {
  background-color: #ffffff;
  /* padding: 10px; */
  border-radius: 10px;
}

.orderhistory--container {
}

.orderhistory--single--list {
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

.orderhistory--table--th {
  font-size: 15px;
  font-weight: 700;
  margin: 5px;
}
</style>
