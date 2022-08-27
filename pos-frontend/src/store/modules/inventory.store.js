import { getProductByName } from "@/service/product.service"

export default {
    state : {
        productist : [],
        searchedList : []
    },
    getters : {
        getProductList(state){
            return state.productist;
        },
        getSearchList(state){
            return state.searchedList;
        }
    },
    mutations : {
        updateProductList(state,value){
            state.productist = value;
        },
        updateSearchList(state,value){
            state.searchedList = value;
        }
    },
    actions :{
        // GET_PRODUCT_LIST(context){

        // }
        SEARCH_THE_PRODUCT({commit}, value = ""){
            getProductByName({
                searchKey : value,
                successCallback : ({data}) => {
                    commit("updateSearchList",data)
                },
                errrorCallback : (errorResponse) => {
                    console.log(errorResponse)
                }
            })
        }
    }
}