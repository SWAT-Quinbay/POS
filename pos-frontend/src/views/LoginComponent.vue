<template>
  <div class="login">
  <form style="margin-top:10px;margin-bottom:10px;">
   <center><h4 style="color:#FF6665; font-style:bold; margin-bottom:25px;">LOGIN</h4></center>
      <label for="name">Enter Name:</label><br>
      <input type="text" required><br><br>
      <label for="Password">Enter Password:</label><br>
      <input type="text" required><br><br>
       <br /><br><center>
      <button style="border:1px solid white; border-radius:7px; color:white; background-color:#FF6665; padding:5px; margin-top:-25px" type="button">SIGN IN</button><br />
      If you do not have an account click<a href="form.html">sign up </a></center>
  </form>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.login{
    margin-left: 200px;
    margin-top: 20vh;
    background-color: white;
     color:black;
     width:70%;
     margin-left:20vw;
     border-radius:40px;
     border:0.5px solid #FF6665;
     box-shadow:rgba(0, 0, 0, 0.1) 0px 4px 6px -1px, rgba(0, 0, 0, 0.06) 0px 2px 4px -1px;
}
input{
    border-radius: 10px;
    width:250px;
    background:#F2F1EF;
    border:1px solid #FF6665;
}

label{
    font-size:20px;
    font-style: bold;
}
input,label{
  margin-left:30%;
}
</style>