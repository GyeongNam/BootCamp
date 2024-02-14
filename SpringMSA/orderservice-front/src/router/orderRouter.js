import OrderList from "@/views/OrderList.vue";
import OrderCart from "@/views/OrderCart.vue";

export const orderRoutes = [
    {
        path : '/orders',
        name : 'OrderList',
        component : OrderList
    }
    ,
    {
        path : '/myCart',
        name : 'OrderCart',
        component : OrderCart
    }
]