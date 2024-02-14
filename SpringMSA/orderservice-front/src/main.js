import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import '@/assets/css/bootstrap.min.css'
import axios from 'axios'
import store from './store/cart.js'

// index.html 의 id 의 app 에 마운트가 되도록 하는 코드
// createApp(App).mount('#app')

const app = createApp(App)

/*
401 응답의 경우 interceptor 를 통해 고통적으로 토큰 제거 후 로그아웃
 */
axios.interceptors.response.use(response => response, error => {
    if(error.response && error.response.status === 401){
        localStorage.clear();
        // location.href = "/login";
    }
    return Promise.reject(error);
})

app.use(router);
app.use(store);
app.mount('#app')