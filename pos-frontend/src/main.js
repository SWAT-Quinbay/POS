import Vue from 'vue'
import App from './App.vue'
// import './index.css'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueToast from 'vue-toast-notification';
// Import one of the available themes
//import 'vue-toast-notification/dist/theme-default.css';
import 'vue-toast-notification/dist/theme-sugar.css';

// Vue.use(VueToast);

Vue.use(BootstrapVue)

Vue.use(VueToast, {
  position: "bottom-right",
  duration: 4000
});

import store from  "@/store/index";
import router from "@/router/index"
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faKey, faMagnifyingGlass, faUser } from '@fortawesome/free-solid-svg-icons'
library.add(faMagnifyingGlass)
library.add(faUser)
library.add(faKey)
Vue.config.productionTip = false
Vue.component('font-awesome-icon', FontAwesomeIcon)
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
