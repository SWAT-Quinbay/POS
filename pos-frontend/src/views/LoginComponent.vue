<template>
  <div class="container login--body">
    <div class="row justify-content-center">
      <div class="col-11 col-md-4">
        <div class="login">
          <center>
            <h4 class="login--header">LOGIN</h4>
          </center>
          <div class="action--form--controller">
            <label for="user-name" class="action--input--label"
              >Enter Username:</label
            >
            <input
              type="text"
              v-model="userdata.user"
              class="action--input"
              placeholder="Enter Your Username"
            />
          </div>
          <div class="action--form--controller">
            <label for="user-password" class="action--input--label"
              >Enter Password:</label
            >
            <input
              type="password"
              v-model="userdata.password"
              class="action--input"
              placeholder="Enter Your Password"
            />
          </div>
          <span v-if="UnAuthorized" style="color: red; text-align: center"
            >Wrong Credentials! Acces Denied.</span
          ><div class="login--button">
          <div class="row justify-content-center">
            <div class="col-7">
              
            <ButtonComponent
            label="Login"
            buttonStyle="btn--primary"
            @onClick="sendUserStore()"
            type="button"
          />
            </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import ButtonComponent from "@/components/ButtonComponent.vue";
export default {
  data() {
    return {
      userdata: {
        user: "",
        password: "",
      },
      UnAuthorized: false,
    };
  },
  components: {
    ButtonComponent,
  },
  methods: {
    sendUserStore() {
      console.log("SUBMITTED");
      if (this.userdata.user == "admin" && this.userdata.password == "admin") {
        localStorage.setItem("isAuthenticated", true);
        this.$store.dispatch("VALIDATE_USER", true);
        this.$router.push(`/`);
      } else {
        Vue.$toast.error("Invalid Cret!");
        this.UnAuthorized = true;
      }
    },
  },
};
</script>

<style scoped>
.action--input--label {
  font-size: 14px;
  font-weight: 700;
}

.action--input {
  width: 100%;
  height: 40px;
  background-color: #f1f1f1;
  border-radius: 10px;
  border: 1px solid #f1f1f1;
  margin-top: 5px;
  padding-left: 10px;
  outline: none;
}

.action--input:focus {
  border: 1px solid #ff6665;
}

.action--form--controller {
  margin-bottom: 20px;
}

.login {
  margin-top: 20vh;
  margin-bottom: 20vh;
  background-color: white;
  color: black;
  border-radius: 7px;
  padding: 20px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 6px -1px,
    rgba(0, 0, 0, 0.06) 0px 2px 4px -1px;
}

.login--body {
  height: 100vh;
}

.login--header {
  color: #ff6665;
  padding-top: 5px;
  font-style: bold;
  margin-bottom: 25px;
  font-weight: bold;
}

.login--button{
  margin-top : 40px;
  margin-bottom : 25px;
}
</style>
