import Vue from "vue";
import Router from "vue-router";

import store from  "@/store/index";

import HomePage from "@/views/HomePage.vue";
import OrderHistory from "@/views/OrderHistory.vue";
import InventoryPage from "@/views/InventoryPage.vue";
import LoginComponent from "@/views/LoginComponent.vue";
import RegisterComponent from "@/views/RegisterComponent.vue";
Vue.use(Router);

const router = new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "HomePage",
      component: HomePage,
    },
    {
      path: "/login",
      name: "LoginPage",
      component: LoginComponent,
    },
    {
      path: "/orderhistory",
      name: "OrderHistory",
      component: OrderHistory,
    },
    {
      path: "/inventory",
      name: "InventoryPage",
      component: InventoryPage,
    },
    {
      path: "/register",
      name: "RegisterComponent",
      component: RegisterComponent,
    },
  ],
});

router.beforeEach((to, from, next) => {
  
  const auth = localStorage.isAuthenticated;
  store.dispatch('VALIDATE_USER', auth === "true")

  if (to.name !== "LoginPage" && auth === undefined)
    next({ name: "LoginPage" });
  else next();

});

export default router;
