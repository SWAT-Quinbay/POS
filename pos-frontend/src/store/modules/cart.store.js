import Vue from "vue";

export default {
    state : {
        cartProductList : [],
        tax : 5
    },
    getters : {
        getCartProduct(state){
            return state.cartProductList;
        },
        getTotalPrice(state){
            return Math.floor(state.cartProductList.reduce((accum,item) => accum + (item.price * item.quantity), 0))
        },
        getTax(state){
          return state.tax;
        }
    },
    mutations : {
        addProductToCart(state, { product }) {
          console.log(product)
            const constructedProduct = {
              quantity: 1,
              inventoryQuantity : product.quantity,
              id: product.id,
              imageUrl: product.imageUrl,
              description : product.description,
              name: product.name,
              price : product.price
            };
            let item = state.cartProductList.find((item) => item.id == product.id);
            if (item){
              if(item.quantity < item.inventoryQuantity){
                item.quantity++;
              }else{
                Vue.$toast.error("Out of Stock, Please go for other!");
              }
              
            }
            else{
              state.cartProductList.push({ ...constructedProduct });
            }
          },
      
          decreaseProductQuantity(state, { productId }) {
            let item = state.cartProductList.find((item) => item.id == productId);
            if (item.quantity > 1) item.quantity--;
          },
      
          removeProductFromCart(state, { productIndex }) {
            state.cartProductList.splice(productIndex, 1);
          },

          clearCart(state){
            state.cartProductList = [];
          }
    },
    actions :{
        ADD_PRODUCT_TO_CART({ commit },product){
            commit('addProductToCart', product)
        },
        REMOVE_PRODUCT_FROM_CART({ commit },{productIndex}){
          console.log(productIndex)
            commit('removeProductFromCart', {productIndex})
        },
        DECREASE_PRODUCT_QUANTITY({ commit },productId){
            commit('decreaseProductQuantity', productId)
        },
    }
}