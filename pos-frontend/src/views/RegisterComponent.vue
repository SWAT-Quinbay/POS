<template>
  <div class="login">
  <form style="margin-top:0px;margin-bottom:10px;">
   <center><h4 style="color:white; padding-top:5px; font-style:bold; margin-bottom:25px; background:#FF6665">REGISTER USER</h4></center>
<b>  <label for="firstname">First Name</label><br>
      <input v-model="registerdata.fname" type="text" placeholder="First Name" required><br><br>
      <label for="lastname">Last Name</label><br>
      <input v-model="registerdata.lname" type="text" placeholder="Last Name" required><br><br>
       <label for="email">Email</label><br>
      <input v-model="registerdata.email" type="text" placeholder="Email" required><br><br>
       <label for="Password">Password</label><br>
      <input v-model="registerdata.password" type="text" placeholder="Password" required><br><br>
       <label for="confirmPassword">Confirm Password</label><br>
      <input v-model="registerdata.confirmpassword" placeholder="Confirm Password" type="text" required><br><br>
       <br /><br><center>
      <button @click="sendRegisterStore()" style="border:1px solid white; border-radius:7px; color:white; background-color:#FF6665; padding:5px; margin-top:-25px" type="button">Register User</button><br />
      </center></b>
  </form>
  </div>
</template>

<script>
export default {
  data()
  {
    return{
      registerdata:{
         fname:"",
         lname:"",
         password:"",
         confirmpassword:"",
         email:""
      }
    }
  },
  methods:
  {
    sendRegisterStore()
    {
      this.$store.dispatch('REGISTER_USER',this.registerdata);
    }
  }


}
</script>

<style scoped>
.login{
    margin-left: 200px;
    margin-top: 10vh;
    background-color: white;
     color:black;
     width:55%;
     margin-left:20vw;
     border-radius:7px;
     border:0.5px solid #FF6665;
     box-shadow:rgba(0, 0, 0, 0.1) 0px 4px 6px -1px, rgba(0, 0, 0, 0.06) 0px 2px 4px -1px;
}
input{
    border-radius: 5px;
    width:250px;
    background:#F2F1EF;
    border:1px solid #FF6665;
}

label{
    font-size:15px;
    font-style: bold;
}
input,label{
  margin-left:30%;
}

</style>