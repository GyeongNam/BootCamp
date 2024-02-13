import ItemList from "@/views/ItemList.vue";
import ItemListManage from "@/views/ItemListManage.vue";
import ItemCreate from "@/views/ItemCreate.vue";

export const ItemRoutes = [
    {
        path : '/items',
        name : 'ItemList',
        component : ItemList
    },
    {
        path: '/item/manage',
        name : 'ItemListManage',
        component:  ItemListManage
    },
    {
        path: '/item/create',
        name : 'ItemCreate',
        component:  ItemCreate
    }
]