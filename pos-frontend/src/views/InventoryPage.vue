<template>
<div>
   <div class="inventory">
  <table  class="sfdk">
    <tr><th><h2 style=" color:#FF6665;font-family:Impact,fantasy;">INVENTORIES</h2></th>
        <th></th><th></th><th style="display:;"><input style="border-radius:10px; height:30px;width:250px;" type="text" placeholder="search inventory"><button style="color:white; font-size:15px; width:30px"><font-awesome-icon icon="fa-solid fa-magnifying-glass" /></button></th></tr>
    <tr style="color:white; font-size:18px; background:black;"><th></th>
        <th>ID</th>
        <th>Name</th>
         <th>Price</th>
         <th></th>
         </tr>

    <tr v-for="(items,index) in product" :key=index>
        <td style="padding-right:20px;"><img style="border-radius:8px;" :src="items.image" height="100px" width="100px"></td>
        <td style="padding-right:20px;">{{items.id}}</td>
        <td style="padding-right:20px;">{{items.name}}</td>
        <td style="padding-left:20px;">{{items.price}}
         <button @click="show()" style="color:black; margin-left:50px;" type="button">Edit</button></td>
        </tr>
  </table>
</div>
 <ModalComponent v-show="showModal" @close-modal="showModal=false"/>
 </div>
</template>
<script>
import demoProducts from '../utils/demoProducts'
import ModalComponent from './ModalComponent.vue'
export default {
     name : "InventoryPage",
     data(){
        return{
            product:demoProducts,
             showModal:false
        }
     },
     components:{
        ModalComponent
     },
     methods:
     {
       show()
       {
          this.showModal=true;
       }
     }
    
}
</script>
<style>
.inventory{
   width:80% ; 
   margin-left:15%;
   background: white; 
    border:2px solid black;
    border-radius:35px;
     padding-left:10px;
}
.table td{
    
    background:white;
     border: 5px solid rgb(0, 0, 0);
     padding-right: 5px;
}
.table tr{
    border: 5px solid rgb(0, 0, 0);
}
/* .table tr{
    border: 4px solid darkgrey;
    border-radius:50px;
} */
.table button{
    color:black;
    font-family: fantasy;
    border-radius: 8px;
}
</style>

