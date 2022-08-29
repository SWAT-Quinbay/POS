 import axios from 'vuex';
import { baseUserUrl } from "@/utils/urls"


 export const validateUser = ( {userData , success, error}) => {
    axios
      .post(`${baseUserUrl}/login?name=admin&password=admin`, userData)
      .then((response) => {
        console.log("login API service succes..!")
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }
