<template>
  <b-modal
      title="Modal Variants"
    >
      <div><h1>Hello world</h1></div>
    </b-modal>
</template>

<script>
// import ButtonComponent from "@/components/ButtonComponent.vue";

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
    },
    showModal : {
      type : Boolean,
      default :false
    }
  },
  components: {
    // ButtonComponent,
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
