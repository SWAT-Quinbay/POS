import axios from 'vuex'
import { baseUrl } from "@/utils/urls"
export const registerUser = ( {registerData , success, error}) => {
   axios
     .post(`${baseUrl}` , registerData)
     .then((response) => {
       success && success(response);
     })
     .catch((e) => {
       error && error(e);
     });
 }
