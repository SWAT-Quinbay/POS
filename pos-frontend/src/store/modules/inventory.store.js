export default {
    state : {
        productist : []
    },
    getters : {
        getProductList(state){
            return state.productist;
        }
    },
    mutations : {
        updateProductList(state,value){
            state.productist = value;
        }
    },
    actions :{
        // GET_PRODUCT_LIST(context){

        // }
    }
}