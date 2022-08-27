<template>
  <div
    class="action--modal"
  >
    <div class="modal--dialog modal--dialog-centered">
      <div class="modal--content">
        <div class="modal--header">
          <h5 class="modal--title">{{ modalData.modalHeader }}</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal--body">
          <!-- <svg id="msi"></svg> -->
          <div class="action--form--controller">
            <label for="product-name" class="action--input--label">Product Name</label>
            <input type="text" v-model="product.productName" class="action--input" placeholder="Enter Product Name">
          </div>
          <div class="action--form--controller">
            <label for="product-description" class="action--input--label">Product Description</label>
            <input type="text" v-model="product.productDescription" class="action--input" placeholder="Enter Product Name">
          </div>
          <div class="action--form--controller">
            <label for="product-price" class="action--input--label">Product Price</label>
            <input type="text" v-model="product.productPrice" class="action--input" placeholder="Enter Product Name">
          </div>
          <div class="action--form--controller">
            <label for="product-quantity" class="action--input--label">Product Quantity</label>
            <input type="number" v-model="product.productQuantity" class="action--input" placeholder="Enter Product Name">
          </div>

        </div>
        <div class="modal--footer d-flex flex-row">
          <div>
            <ButtonComponent
              label="Close"
              @onClick="() => {}"
              type="button"
              buttonStyle="btn--primary--outline"
              data-bs-dismiss="modal"
            />
          </div>
          <div>
            <ButtonComponent
              :label="modalData.modalButtonName"
              @onClick="() => {}"
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
      state: false,
      product : {
        productName : "",
        productPrice : 0,
        productDescription : "",
        productQuantity : 0
      }
    };
  },
  props: {
    modalAccessIdName: {
      type: String,
      default: "",
    },
    modalData : {
      type : Object,
      default : () => {}
    }
  },
  components: {
    ButtonComponent,
  },
  methods: {
    showsaved() {
      return this.state = true;
    },
    updateInfo(){
      this.$emit("")
    }
  }
  // mounted() {
  //   console.log(this.modalData)
  //   this.product=this.modalData
  //   // const OldInfo = {
  //   //   productName : this.modalData.productData.name,
  //   //   productPrice : this.modalData.productData.price,
  //   //   productDescription : this.modalData.productData.description,
  //   //   productQuantity : this.modalData.productData.quantity
  //   // }
  //   // console.log(OldInfo)
  //   // this.product = OldInfo
  // },
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














/* .modover {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  background-color: #000000da;
}

.mod {
  text-align: left;
  background-color: white;
  height: 500px;
  width: 500px;
  margin-top: 10%;
  padding: 60px 0;
  border: 2px solid #ff6665;
  border-radius: 20px;
  padding-left: 25px;
}
.mod input {
  border-radius: 10px;
  width: 300px;
}
.close {
  margin: 10% 0 0 16px;
  cursor: pointer;
}

.close-img {
  width: 25px;
}

.check {
  width: 150px;
}

h6 {
  font-weight: 500;
  font-size: 28px;
  margin: 20px 0;
}

p {
  font-size: 16px;
  margin: 20px 0;
  color: black;
}

button {
  background-color: #ff6665;
  width: 100px;
  height: 40px;
  color: black;
  font-size: 14px;
  border-radius: 16px;
  margin-top: 50px;
} */
</style>
