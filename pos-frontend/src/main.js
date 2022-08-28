import Vue from 'vue'
import App from './App.vue'
// import './index.css'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

import store from  "@/store/index";
import router from "@/router/index"
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/* import specific icons */
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons'
library.add(faMagnifyingGlass)
Vue.config.productionTip = false
Vue.component('font-awesome-icon', FontAwesomeIcon)
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
