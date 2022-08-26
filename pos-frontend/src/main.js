import Vue from 'vue'
import App from './App.vue'
// import './index.css'
import 'bootstrap/dist/css/bootstrap.min.css'

import store from  "@/store/index";
import router from "@/router/index"

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
