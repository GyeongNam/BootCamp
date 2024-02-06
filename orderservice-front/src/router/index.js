import {createRouter, createWebHistory} from 'vue-router';
import HomeComponent from "@/components/HomeComponent.vue";
import MemberList from "@/views/MemberList.vue";
import LoginComponent from "@/views/LoginComponent.vue";

const routes = [
    {
        path: '/',
        name: 'HOME',
        component: HomeComponent
    }
    ,
    {
        path: '/members',
        name: 'MemberList',
        component: MemberList
    }
    ,
    {
        path: '/login',
        name: 'LoginComponent',
        component: LoginComponent
    }

]

const router = createRouter({
    history : createWebHistory(),
    routes
})

export default router;