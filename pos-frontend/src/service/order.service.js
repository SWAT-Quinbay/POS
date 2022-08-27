import axios from "axios";
import { baseUrl } from "@/utils/urls"

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

export const getOrderHistory = ({ success, error }) => {
  axios
    .get(`${baseUrl}`)
    .then((response) => {
      success && success(response);
    })
    .catch((e) => {
      error && error(e);
    });
}


