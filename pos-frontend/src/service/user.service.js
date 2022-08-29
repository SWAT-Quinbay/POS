 import axios from 'vuex'
 export const validateUser = ( {userData , success, error}) => {
    axios
      .post(`http://192.168.0.140:8082/login?name=admin&password=admin`, userData)
      .then((response) => {
        console.log("login API service succes..!")
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }
