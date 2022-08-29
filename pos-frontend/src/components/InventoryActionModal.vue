<template>
  <div class="modal--bg">
    <div class="modal--content">
    <div class="modal--header d-flex justify-content-between align-items-center">
      <div>
        <p class="modal--header--text">{{ modalHeader }}</p>
      </div>
      <div>
        <span class="close" @click="closeModal">&times;</span>
      </div>
    </div>
        <div class="modal--body">
          <div class="action--form--controller">
            <label for="product-name" class="action--input--label">Product Name</label>
            <input type="text" v-model="product.name" class="action--input" placeholder="Enter Product Name">
          </div>
           <div class="action--form--controller">
            <label for="product-name" class="action--input--label">Product Image Url</label>
            <input type="text" v-model="product.imageUrl" class="action--input" placeholder="Paste Imgage Url">
          </div>
          <div class="action--form--controller">
            <label for="product-description" class="action--input--label">Product Description</label>
            <input type="text" v-model="product.description" class="action--input" placeholder="Enter Product Description">
          </div>
          <div class="action--form--controller">
            <label for="product-price" class="action--input--label">Product Price</label>
            <input type="text" v-model="product.price" class="action--input" placeholder="Enter Product Price">
          </div>
          <div class="action--form--controller">
            <label for="product-quantity" class="action--input--label">Product Quantity</label>
            <input type="text" v-model="product.quantity" class="action--input" placeholder="Enter Product Quantity">
          </div>
        </div>

        <div class="modal--footer">
           <div class="d-flex justify-content-end gap-1">
            <div class="col-3">
              <ButtonComponent
              label="Close"
              buttonStyle="btn--primary--outline"
              @onClick="closeModal()"
              type="button"
            />
            </div>
            <div class="col-auto">
            <ButtonComponent
              :label="modalButtonLabel"
              buttonStyle="btn--primary"
              @onClick="actionToDB()"
              type="button"
            />
            </div>
           </div>
        </div>
    </div>
  </div>
</template>

<script>
import ButtonComponent from "@/components/ButtonComponent.vue";

export default {
  data() {
    return {
        product : {
          id : "",
          name : "",
          imageUrl : "",
          price : "",
          quantity : "",
          description : ""
        },
        modalHeader : "",
        modalButtonLabel : ""
    };
  },
  props: {
    modalObjectData : {
      type : Object,
      default : () => {}
    }
  },
  components: {
    ButtonComponent,
  },
  methods: {
    actionToDB(){
      this.$emit("callBackForAction", this.product)
    },
    closeModal(){
      this.$emit("closeModal")
    }
  },
  mounted() {
    const propsProduct = this.modalObjectData.productData;
    console.log(this.modalObjectData)
    if(propsProduct !== null){
      this.product.id = propsProduct.id;
      this.product.name = propsProduct.name;
      this.product.imageUrl = propsProduct.imageUrl;
      this.product.price = propsProduct.price;
      this.product.quantity = propsProduct.quantity;
      this.product.description = propsProduct.description;
    }
      this.modalHeader = this.modalObjectData.modalHeader;
      this.modalButtonLabel = this.modalObjectData.modalButtonName  
  },
};
</script>

<style scoped>


.action--input--label{
  font-size: 14px;
  font-weight: 700;
}

.action--input{
  width: 100%;
  height: 40px;
  background-color: #F1F1F1;
  border-radius: 10px;
  border: 1px solid #F1F1F1;
  margin-top : 5px;
  padding-left : 10px;
   outline: none;
}

.action--input:focus{
   border: 1px solid #FF6665;
}


.action--form--controller{
  margin-bottom: 20px;
}


.modal--bg{
  position: fixed;
  left: 0;
  top: 0; 
  z-index: 1;
  width: 100%;
  height: 100%; 
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.481); ;
}


.modal--content {
  background-color: #fefefe;
  margin: 5% auto; 
  /* padding: 20px; */
  border: 1px solid #888;
  width: 40%; 
  border-radius: 10px;
}

.close {
  color: #aaa;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.modal--header--text{
  margin: 0;
}

.modal--header{
  border-bottom: 1px solid rgb(202, 202, 202);
  padding: 5px 20px;
}

.modal--footer{
  border-top: 1px solid rgb(202, 202, 202);
  padding: 10px 20px;
}

.modal--body{
  padding: 10px 20px;
}

</style>
