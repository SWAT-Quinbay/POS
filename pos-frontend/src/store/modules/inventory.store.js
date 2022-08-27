import { getProductByName , getInventory } from "@/service/product.service"

export default {
    state : {
        productList : [],
        searchedList : []
    },
    getters : {
        getProductList(state){
            return state.productList;
        },
        getSearchList(state){
            return state.searchedList;
        }
    },
    mutations : {
        updateProductList(state,value){
            state.productList = value;
        },
        updateSearchList(state,value){
            state.searchedList = value;
        }
    },
    actions :{
        GET_PRODUCT_LIST({commit}){
            getInventory({
                successCallback : ({data}) => {
                    commit("updateProductList",data.content)
                },
                errrorCallback : (errorResponse) => {
                    console.log(errorResponse)
                }
            })
        },
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