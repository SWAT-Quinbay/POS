import Vue from "vue";
import Vuex from "vuex";

import inventory from "@/store/modules/inventory.store"
import cart from "@/store/modules/cart.store"

Vue.use(Vuex);


export default new Vuex.Store({
    modules : {
      cart,
      inventory
    }
  });
  