import { getOrderHistory  } from "@/service/order.service"

export default {
    state : {
        orderHistory : []
    },
    getters : {
        getOrderHistory(state){
            return state.orderHistory;
        }
    },
    mutations : {
        updateOrderHistory(state,value){
            state.orderHistory = value;
        }
    },
    actions :{
        GET_ORDER_HISTORY({commit}){
            getOrderHistory({
                successCallback : ({data}) => {
                    console.log(data)
                    commit("updateOrderHistory",data.content)
                },
                errrorCallback : (errorResponse) => {
                    console.log(errorResponse)
                }
            })
        }
    }
}