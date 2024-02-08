import {createRouter, createWebHistory} from 'vue-router';
import HomeComponent from "@/components/HomeComponent.vue";
import LoginComponent from "@/views/LoginComponent.vue";
import {memberRoutes} from "@/router/memberRouter.js";
// export default 인 경우에는 {} 가 필요없고, 여러개 요쇼가 있을 경우에는 {}필요
import {orderRoutes} from "@/router/orderRouter";
import {ItemRoutes} from "@/router/ItemRouter";

const routes = [
    {
        path: '/',
        name: 'HOME',
        component: HomeComponent
    }
    ,
    {
        path: '/login',
        name: 'Login',
        component: LoginComponent
    },
    // 스프레드 연산자로 불리고,. 주로 배열요소를 달흔 배열요소에 합할때 사용
    ...memberRoutes,
    ...orderRoutes,
    ...ItemRoutes


]

const router = createRouter({
    history : createWebHistory(),
    routes
})

export default router;