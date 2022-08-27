<template>
  <div class="modover">
    <p style="color:black; font-family:fantasy;">Enter the Details to be edited</p>
    <div class="mod">
    <label>Product Name :</label><br>
    <input type="text" value=""><br>
    <label>Price :</label><br>
    <input type="text" value=""><br>
     <label>Product Description:</label><br>
    <input type="text" value=""><br>
     <label>Image Url:</label><br>
    <input type="text" value=""><br>
      <p v-show="stat">Changes Applied..!</p>
      <button @click="showsaved()">Apply</button>
      <button @click="$emit('close-modal')">Close</button> 
    </div>
    <div class="close">
      <img class="close-img" src="" alt="" />
    </div>
  </div>
</template>

<script>
export default {
    data()
    {
        return{
            stat:false
        }
    },
    methods:{
        showsaved()
        {
            return this.stat=true;
        }

    }
}
</script>

<style>
.modover {
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
  border:2px solid #FF6665;
  border-radius: 20px;
  padding-left:25px;
  
}
.mod input{
    border-radius: 10px;
    width:300px
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
  color:black;
}

button {
  background-color: #FF6665;
  width: 100px;
  height: 40px;
  color: black;
  font-size: 14px;
  border-radius: 16px;
  margin-top: 50px;
}
</style>