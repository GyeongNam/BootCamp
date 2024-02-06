import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import '@/assets/css/bootstrap.min.css'


// index.html 의 id 의 app 에 마운트가 되도록 하는 코드
// createApp(App).mount('#app')

const app = createApp(App)

app.use(router);
app.mount('#app')