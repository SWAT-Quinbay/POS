<template>
    <div>
        <div class="product--card">
            <img :src="product.imageurl" class="product--image" alt="product">
                <div class="row text-center mt-4">
                    <div class="col-12">
                        <p class="product--name">{{ product.name }}</p>
                        <p class="product--price">₹ {{ product.price }}</p>
                    </div>
                </div>
                <!-- <div class="d-flex justify-content-between align-items-end">
                    <div class="">
                        <p class="product--price"></p>
                    </div>
                    <div class="">
                        <img :src="product.image" class="product--image" alt="product">
                    </div>
                </div> -->
               <div class="mt-3">
                 <ButtonComponent
                label="Add to Bag"
                buttonStyle="btn--primary--outline"
                @onClick="addToCart(product)"
                type="button"
            />
               </div>
        </div>
    </div>
</template>
<script>

import ButtonComponent from "@/components/ButtonComponent"

export default {
    name : "ProductCard",
    props : {
        product : {
            type : Object,
            default : () => {}
        }
    },
    components : {
        ButtonComponent
    },
    methods: {
        addToCart(){
            this.$emit("addToCart")
        }
    },
}
</script>
<style scoped>
    .product--card{
        background-color: #FFFFFF;
        border: 0.3px solid #eaeaea;
        /* box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px; */
        box-shadow: rgba(0, 0, 0, 0.04) 0px 3px 5px;
        border-radius: 15px;
        padding: 15px;
        margin-bottom: 20px;
        display: flex;
        flex-direction: column;
        min-height: 200px;
        justify-content: space-between;
    }

    /* .product--card:hover{
        box-shadow: rgba(0, 0, 0, 0.124) 0px 3px 5px;
        transition-duration: 0.2s;
        cursor: pointer;
    } */

    .product--name{
        color: #000000;
        font-weight: 800;
        font-size: 17px;
        margin: 0px;
    }

    .product--price{
        font-size: 15px;
        color: #747474;
        margin: 0px;
        font-weight: 500;
    }

    /* .product--price{
        color: #F07613;
        font-size : 17px;
        font-weight: bold;
        margin:0px;
        margin-bottom: 10px;
    } */

    .product--image{
        width: 100%;
        max-height: 150px;
        border-radius: 15px;
    }
</style>