import {createStore} from "vuex";

/*
initState, updateLocalStorage 와 같은 함수는 스토어 정의 바깥에 위치
책임과 권한을 분리하는 개념적인 의도도 있지만, 다른 스토어나 다른 상황에서 재사용성을 높이기 위한
 */
function initState() {
    return{
        cartItems: JSON.parse( localStorage.getItem('cartItems') ) || [],
        totalQuantity: localStorage.getItem('totalQuantity') || 0
    }
}
function updateLocalStorage(cartItems, totalQuantity ){
    localStorage.setItem('cartItems', JSON.stringify(cartItems))
    localStorage.setItem('totalQuantity', totalQuantity)
}

export default createStore({
    // state 는 상태를 의미하는 객체로써 initState 를 통해 상태 초기화
    state: initState,

    /*
    mutations 는 상태를 변경하는 함수들의 집합
    vuex에서는 커밋이라는 용어는 상태변경을 위해 mutations 을 호출하는 과정을 의미
     */
    mutations:{
        // addToCart 함수는 외부 컴포넌트(또는 action)에서 호출될 예정
        addToCart(state, item){
            const existItem = state.cartItems.find(i => i.item_id == item.item_id);
            if(existItem){
                existItem.count += item.quantity;
            }else{
                state.cartItems.push(item)
            }
            state.totalQuantity = parseInt(state.totalQuantity) + parseInt(item.quantity);
            updateLocalStorage(state.cartItems, state.totalQuantity)
        }
        ,
        clearCart(state){
            state.cartItems = [];
            state.totalQuantity = 0;
            updateLocalStorage(state.cartItems,state.totalQuantity);
        }
    },
    /*
    actions 을 통해 여러 뮤테이션을 연속적으로 커밋하거나, 비동기 작업을 진행
    일반적으로 component 에서 actions 의 메서드를 호출하고, actions 에서 mutations 메서드 호출.
     */
    actions:{
        /*
        context 매개변수가 주입, context 매개변수 안에 state, commit 등이 존재
         */
        addToCart(context, item){
            context.commit("addToCart", item)
        },
        clearCart(context){
            context.commit("clearCart")
        }
    }
    ,
    // getters 는 상태들을 반환하는 함수들의 집합
    getters:{
        getCartItems: state => state.cartItems,
        getTotalQuantity : state => state.totalQuantity
    }
});