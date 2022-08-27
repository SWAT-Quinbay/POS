<template>
  <div>
    <div
      class="modal fade"
      :id="modalAccessIdName"
      tabindex="-1"
      :aria-labelledby="modalAccessIdName + 'label'"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Order Summary</h5>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <!-- <svg id="msi"></svg> -->
            <vue-html2pdf
              :show-layout="false"
              
              :enable-download="true"
              :preview-modal="true"
              :paginate-elements-by-height="3000"
              filename="hee hee"
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
                              Date: {{ getData }}
                            </p>
                          </div>
                          <div class="col-auto px-0">
                            <p class="m-0 small billText">
                              Time: {{ getTime }}
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

                        <div v-if="cartProducts.length">
                          <div
                            class="row justify-content-between m-0"
                            v-for="(data, index) in cartProducts"
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
                              <p class="m-0 small billText">{{ data.count }}</p>
                            </div>
                            <div class="col-2 px-0 text-end">
                              <p class="m-0 small billText">
                                ₹ {{ data.price * data.count }}
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
                            <p class="m-0 small billText">₹ {{ totalPrice }}</p>
                          </div>
                        </div>
                        <div class="row justify-content-between m-0">
                          <div class="col-6 px-0">
                            <p class="m-0 small billText">
                              Tax {{ tax }}% (VAT Included)
                            </p>
                          </div>
                          <div class="col-3 px-0 text-end">
                            <p class="m-0 small billText">
                              ₹ {{ calculateTax }}
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
                              ₹ {{ getNetPrice }}
                            </p>
                          </div>
                        </div>
                        <div class="mt-2 mb-3 hr-bill"></div>
                        <div class="row justify-content-between m-0 mb-2">
                          <div class="col-6 px-0">
                            <p class="m-0 loyaltyPoints">
                              TOTAL ITEMS : {{ cartProducts.length }}
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
          <div class="modal-footer d-flex flex-row">
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
                label="Download Bill"
                @onClick="downloadBill()"
                type="button"
              />
            </div>
            <div>
              <ButtonComponent
                label="Save and Generate Bill"
                @onClick="()=>{}"
                type="button"
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import ButtonComponent from "@/components/ButtonComponent.vue";
import { mapGetters } from "vuex";
import VueHtml2pdf from "vue-html2pdf";

// JsBarcode("#msi", "123456", {format: "msi"})

export default {
  name: "BillingModal",
  props: {
    // orderData: {
    //   type: Object,
    //   default: () => {},
    // },
    modalAccessIdName: {
      type: String,
      default: "",
    },
  },
  components: {
    ButtonComponent,
    VueHtml2pdf,
  },
  computed: {
    ...mapGetters({
      cartProducts: "getCartProduct",
      totalPrice: "getTotalPrice",
      tax: "getTax",
    }),
    getNetPrice() {
      return Math.floor(this.totalPrice + (this.totalPrice / 100) * this.tax);
    },
    calculateTax() {
      return Math.floor((this.totalPrice / 100) * this.tax);
    },
    getData() {
      const tempTime = new Date();
      return (
        tempTime.getDate() +
        "-" +
        (tempTime.getMonth() + 1) +
        "-" +
        tempTime.getFullYear()
      );
    },
    getTime() {
      const tempTime = new Date();
      return (
        (tempTime.getHours() === 0
          ? 12
          : tempTime.getHours() > 12
          ? tempTime.getHours() - 12
          : tempTime.getHours()) +
        " : " +
        tempTime.getMinutes() +
        " " +
        (tempTime.getHours() < 12 && tempTime.getHours() >= 0 ? "AM" : "PM")
      );
    },
  },
  methods: {
    downloadBill() {
      this.$refs.html2Pdf.generatePdf();
    },
  },
};
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
