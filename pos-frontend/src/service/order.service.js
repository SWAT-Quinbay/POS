import axios from "axios";
import { baseUrl , orderBaseUrl } from "@/utils/urls"

export const createNewOrder = ({ orderData , success ,  error}) => {
  axios
    .post(`${baseUrl}`, orderData)
    .then((response) => {
      success && success(response);
    })
    .catch((e) => {
      error && error(e);
    });
}

export const deleteOrderHistory = ({ orderId , success ,  error}) => {
    axios
      .delete(`${baseUrl}/${orderId}`)
      .then((response) => {
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }

export const getOrderHistory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${orderBaseUrl}/all`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


