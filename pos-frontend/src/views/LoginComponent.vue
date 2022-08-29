<template>
  <div class="login">
  <form style="margin-top:0px;margin-bottom:10px;">
   <center> 
    <h4 style="color:white; padding-top:5px; font-style:bold; margin-bottom:25px; background:#FF6665">LOGIN</h4></center>
    <label for="name"><font-awesome-icon icon="fa-solid fa-user"/> Enter Name:</label><br>
      <input v-model="userdata.user" type="text" placeholder="Username" required><br><br>
      <label for="Password"><font-awesome-icon icon="fa-solid fa-key"/> Enter Password:</label><br>
      <input v-model="userdata.password" type="password" placeholder="Password" required><br><br>
       <br /><center><span v-if="UnAuthorized" style="color:red">Wrong Credentials! Acces Denied.</span></center><br><center>
      <button @click="sendUserStore()" style="border:1px solid white; border-radius:7px; color:white; background-color:#FF6665; padding:5px; margin-top:-25px" type="button">SIGN IN</button><br />
      </center>
  </form>
  </div>
</template>

<script>
export default {
  data()
  {
    return{
      userdata:{
         user:"",
         password:""
      },
      UnAuthorized:false
    }
  },
  methods:
  {
    sendUserStore()
    {
      console.log("SUBMITTED");
      if(this.userdata.user=="admin"&&this.userdata.password=="admin")
      {
       localStorage.token = true;
       this.$router.push(`/`);
    }
    else{
       this.UnAuthorized=true;
    }
  }


}}
</script>

<style scoped>
.login{
    margin-left: 200px;
    margin-top: 20vh;
    background-color: white;
     color:black;
     width:60%;
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