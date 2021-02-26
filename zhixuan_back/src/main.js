import Vue from 'vue'
import ElementUI from "element-ui"
import App from './App.vue'
import router from "./routes"
import 'element-ui/lib/theme-chalk/index.css'; 
import SERVICE_PATH  from './config';


Vue.config.productionTip = false

Vue.prototype.SERVICE_PATH = SERVICE_PATH

Vue.use(ElementUI, {
  size: 'small'
});


new Vue({
  router,
  render: h => h(App), // function(h){return h(App);}
}).$mount('#app')
