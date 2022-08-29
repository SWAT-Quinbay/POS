<template>
    <div>
        <vue-html2pdf
              :show-layout="false"
              :enable-download="true"
              :paginate-elements-by-height="3000"
              filename="orderBill"
              :pdf-quality="2"
              :manual-pagination="false"
              pdf-format="a6"
              pdf-orientation="portrait"
              pdf-content-width="auto"
              @progress="onProgress($event)"
              @hasStartedGeneration="hasStartedGeneration()"
              @hasGenerated="hasGenerated($event)"
              ref="html2Pdf"
            >
              <section slot="pdf-content">
                <div class="inner-bg m-0 p-0">
                  <div class="inner-border py-3">
                    <div class="row m-0">
                      <div class="col-12 text-center mb-3 pt-0">
                        <img
                          src="@/assets/swat.png"
                          class="img-fluid bill-img my-3"
                          width="130"
                          alt=""
                        />
                        <p class="m-0 small billText">22F4+JR6, Peelamedu</p>
                        <p class="m-0 small billText">
                          HUDCO Colony, Coimbatore, Tamil Nadu 641004
                        </p>
                        <p class="m-0 small billText">www.quinbay.com</p>
                        <p class="m-0 small billText">Ph - +91 8903072643</p>
                      </div>
                      <div class="col-12 px-1 text-start">
                        <div class="row justify-content-between m-0">
                          <div class="col-auto px-0">
                            <p class="m-0 small billText">
                              Date: {{ orderData.date }}
                            </p>
                          </div>
                          <div class="col-auto px-0">
                            <p class="m-0 small billText">
                              Time: {{ orderData.time }}
                            </p>
                          </div>
                        </div>
                        <div class="mt-2 mb-1 hr-bill"></div>
                        <div class="row justify-content-between m-0">
                          <div class="col-6 px-0">
                            <p class="m-0 small billText">ITEMS</p>
                          </div>
                          <div class="col-2 px-0 text-end">
                            <p class="m-0 small billText">RATE</p>
                          </div>
                          <div class="col-2 px-0 text-end">
                            <p class="m-0 small billText">QTY</p>
                          </div>
                          <div class="col-2 px-0 text-end">
                            <p class="m-0 small billText">NET</p>
                          </div>
                        </div>
                        <div class="mt-1 mb-2 hr-bill"></div>

                        <div v-if="orderData.totalItems > 0">
                          <div
                            class="row justify-content-between m-0"
                            v-for="(data, index) in orderData.cartProducts"
                            :key="index"
                          >
                            <div class="col-6 px-0">
                              <p class="m-0 billTextName">{{ data.name }}</p>
                            </div>
                            <div class="col-2 px-0 text-end">
                              <p class="m-0 small billText">
                                ₹ {{ data.price }}
                              </p>
                            </div>
                            <div class="col-2 px-0 text-end">
                              <p class="m-0 small billText">{{ data.quantity }}</p>
                            </div>
                            <div class="col-2 px-0 text-end">
                              <p class="m-0 small billText">
                                ₹ {{ data.price * data.quantity }}
                              </p>
                            </div>
                          </div>
                        </div>
                        <div v-else>
                          <p class="m-0 no-products-found">
                            No Products in cart!
                          </p>
                        </div>

                        <div class="mt-3 mb-1 hr-bill"></div>
                        <div class="row justify-content-between m-0">
                          <div class="col-6 px-0">
                            <p class="m-0 small billText">SUBTOTAL</p>
                          </div>
                          <div class="col-3 px-0 text-end">
                            <p class="m-0 small billText">₹ {{ orderData.totalPrice }}</p>
                          </div>
                        </div>
                        <div class="row justify-content-between m-0">
                          <div class="col-6 px-0">
                            <p class="m-0 small billText">
                              Tax {{ orderData.tax }}% (VAT Included)
                            </p>
                          </div>
                          <div class="col-3 px-0 text-end">
                            <p class="m-0 small billText">
                              ₹ {{ orderData.taxAmount }}
                            </p>
                          </div>
                        </div>
                        <div class="mt-1 mb-2 hr-bill"></div>
                        <div class="row justify-content-between m-0">
                          <div class="col-6 px-0">
                            <p class="m-0 small billTextTotal">TOTAL</p>
                          </div>
                          <div class="col-3 px-0 text-end">
                            <p class="m-0 small billTextTotal">
                              ₹ {{ orderData.netPrice }}
                            </p>
                          </div>
                        </div>
                        <div class="mt-2 mb-3 hr-bill"></div>
                        <div class="row justify-content-between m-0 mb-2">
                          <div class="col-6 px-0">
                            <p class="m-0 loyaltyPoints">
                              TOTAL ITEMS : {{ orderData.totalItems }}
                            </p>
                          </div>
                        </div>
                      </div>
                      <div class="col-12 px-1 text-start mb-3">
                        <p class="m-0 small term">TERMS &amp; CONDITIONS</p>
                        <p class="m-0 mt-1 small term">
                          1. Goods sold cannot be returned or exchanged after
                          long time.
                        </p>
                        <p class="m-0 small term">
                          2. Any Complaint on product, the return is eligible
                        </p>
                      </div>
                      <div class="col-12 text-center my-2">
                        <p class="m-0 small billText">
                          ***** Thank You Visit Again *****
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </section>
            </vue-html2pdf>
    </div>
</template>
<script>
import VueHtml2pdf from "vue-html2pdf";
export default {
    name : "BillTemplate",
    data(){
        return{
            orderData : {},
            products : []
        }
    },
    components : {
        VueHtml2pdf
    },
    methods: {
        generateBill(data){
            console.log(data.cartProducts)
            this.orderData = data;
            // setTimeout(()=>{
                this.$refs.html2Pdf.generatePdf();
            // }, 1000);
            
        }
    },
}
</script>
<style scoped>
    .inner-bg {
  background-color: #ffffff;
  padding: 15px;
}

.inner-border {
  border-width: 1px;
  border-radius: 2px;
  border-color: #b1b1b1;
  border-style: dashed;
  padding: 10px;
}

.bill-img {
  margin-top: 10px;
  margin-bottom: 10px;
}

.billText {
  color: #000000;
  font-weight: 600;
  font-size: 12px;
}

.no-products-found {
  color: #000000;
  font-weight: 600;
  font-size: 13px;
  text-align: center;
}

.billTextName {
  color: #000000;
  font-weight: 500;
  font-family: "Noto Sans Tamil", sans-serif;
  font-size: 12px;
}

.billTextTotal {
  color: #000000;
  font-weight: 800;
  font-size: 15px;
}

.paymentType {
  background-color: #000000;
  width: fit-content;
  border-radius: 5px;
  color: #ffffff;
  font-weight: 800;
  font-size: 12px;
}

.term {
  color: #000000;
  font-weight: 600;
  font-size: 12px;
}

.loyaltyPoints {
  color: #000000;
  font-weight: 800;
  font-size: 12px;
}

.rateInfo {
  font-size: 12px;
  font-weight: 800;
}

.hr-bill {
  border-top: 1px dashed #000000;
}
</style>