import Vue from "vue";
import Router from "vue-router";

import HomePage from "@/views/HomePage.vue"
import OrderHistory from "@/views/OrderHistory.vue"
import InventoryPage from "@/views/InventoryPage.vue"
import LoginComponent from "@/views/LoginComponent.vue"
Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
        path : "/",
        name : "HomePage",
        component : HomePage
    },
    {
      path : "/login",
      name : "loginpage",
      component : LoginComponent
  },
    {
        path : "/orderhistory",
        name : "OrderHistory",
        component : OrderHistory
    },
    {
        path : "/inventory",
        name : "InventoryPage",
        component : InventoryPage
    }
  ],
});
