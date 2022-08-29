<template>
  <nav class="navbar navbar-expand-lg" id="navbar--bg">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img
          src="@/assets/swat.png"
          alt=""
          width="80"
          class="d-inline-block align-text-top"
        />
        FoodCourt
      </a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link class="nav-link active" aria-current="page" to="/"
              >Home</router-link
            >
          </li>
          <li class="nav-item">
            <router-link
              class="nav-link active"
              aria-current="page"
              to="/orderhistory"
              >Order History</router-link
            >
          </li>
          <li class="nav-item">
            <router-link
              class="nav-link active"
              aria-current="page"
              to="/inventory"
              >Inventory</router-link
            >
          </li>
        </ul>
        <form class="d-flex" role="search">
          <ButtonComponent
              label="Logout"
              buttonStyle="btn--primary"
              @onClick="()=>{}"
              type="button"
            />
        </form>
      </div>
    </div>
  </nav>
</template>
<script>

import ButtonComponent from "@/components/ButtonComponent.vue"

export default {
  name: "NavBar",
  component : {
    ButtonComponent
  }
};
</script>
<style scoped>
  #navbar--bg {
    background-color: #ffffff;
    box-shadow: rgba(0, 0, 0, 0.04) 0px 3px 5px;
  }
</style>
